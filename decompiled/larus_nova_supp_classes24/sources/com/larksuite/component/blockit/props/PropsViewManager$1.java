package com.larksuite.component.blockit.props;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.larksuite.component.blockit.entity.BatchGetItemTagsResponse;
import com.larksuite.component.blockit.entity.ItemTags;
import com.larksuite.component.blockit.entity.TagInstance;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
class PropsViewManager$1 implements IGetDataCallback<BatchGetItemTagsResponse> {
    final /* synthetic */ i this$0;
    final /* synthetic */ String val$blockId;
    final /* synthetic */ a val$callback;
    final /* synthetic */ e val$finalConfig;
    final /* synthetic */ Map val$hitPointParams;
    final /* synthetic */ ViewGroup val$parentView;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r1) {
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r1) {
        onError(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v11, types: [android.view.View, com.larksuite.component.blockit.props.PropsView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void onSuccess(BatchGetItemTagsResponse r7) {
        ArrayList r0 = new ArrayList();
        Iterator<ItemTags> r8 = r7.itemsTags.values().iterator();
    L4:
        if (r8.hasNext() == false) goto L11;
        ItemTags r1 = r8.next();
        if (TextUtils.equals(this.val$blockId, r1.uniqId) == false) goto L4;
        Iterator<TagInstance> r2 = r1.tags.iterator();
    L9:
        if (r2.hasNext() == false) goto L4;
        TagInstance r3 = r2.next();
        TagInstance.BasicTagInfo r4 = r3.tagInfo;
        r0.add(new f(r4.name, r3.appLink, r4.tagId));
        goto L9
    L11:
        Log.i("PropsViewManager", "tags:" + r0);
        if (this.val$parentView == null) goto L22;
        ?? r9 = new PropsView(this.val$parentView.getContext());
        this.val$parentView.addView(r9, new ViewGroup.LayoutParams(-1, -2));
        r9.x(r0, this.val$hitPointParams);
        if (CollectionUtils.isEmpty(r0) == true) goto L21;
        JSONObject r5 = new JSONObject(this.val$hitPointParams);
        r5.put("tag_count", r0.size());     // Catch: JSONException -> L18
    L20:
        qy7.a.a("pano_show_propsview", r5);
    L18:
        e = move-exception;
        Log.w("PropsViewManager", e);
    L21:
        this.this$0.a.a(this.val$blockId, r9, this.val$callback);
    L23:
        a r10 = this.val$callback;
        if (r10 == null) goto L34;
        r0.size();
        r10.a();
        a r11 = this.val$callback;
        ((SpannableStringBuilder) c.a(r0, null)).toString();
        r11.b();
        return;
    L34:
        return;
    L22:
        this.this$0.a.a(this.val$blockId, null, this.val$callback);
        goto L23
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((BatchGetItemTagsResponse) r1);
    }

    public PropsViewManager$1(i r1, String r2, ViewGroup r3, e r4, Map r5, a r6) {
        this.this$0 = r1;
        this.val$blockId = r2;
        this.val$parentView = r3;
        this.val$hitPointParams = r5;
        this.val$callback = r6;
    }
}
