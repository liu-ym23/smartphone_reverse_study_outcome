package com.larus.setting.impl.thirdpartyaccount.view;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.common.apphost.AppHost;
import com.larus.setting.impl.databinding.LarusItemAccountGroupBinding;
import com.larus.setting.impl.databinding.LarusItemMusicAccountBinding;
import com.tencent.open.log.TraceLevel;
import ct9.a;
import ct9.b;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u000eH\u0016R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bRL\u0010\f\u001a4\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006!"}, d2 = {"Lcom/larus/setting/impl/thirdpartyaccount/view/ThirdPartyAccountAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/setting/impl/thirdpartyaccount/view/ThirdPartyViewHolder;", "<init>", "()V", "renderList", "", "Lcom/larus/setting/impl/thirdpartyaccount/data/ThirdPartyAccountCollectionUiData;", "getRenderList", "()Ljava/util/List;", "setRenderList", "(Ljava/util/List;)V", "onSelectItem", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "scene", "", "thirdPartyKey", "", "getOnSelectItem", "()Lkotlin/jvm/functions/Function2;", "setOnSelectItem", "(Lkotlin/jvm/functions/Function2;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ThirdPartyAccountAdapter extends RecyclerView.Adapter<ThirdPartyViewHolder> {
    public List<a> a;
    public Function2<? super Integer, ? super String, Unit> b;

    public final int getItemCount() {
        List<a> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public ThirdPartyAccountAdapter() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onBindViewHolder(RecyclerView.ViewHolder r17, int r18) {
        ThirdPartyViewHolder r1 = (ThirdPartyViewHolder) r17;
        Intrinsics.checkNotNullParameter(r1, "holder");
        final Function2<? super Integer, ? super String, Unit> r2 = this.b;
        List<a> r3 = this.a;
        if (r3 == null) goto L5;
        a r4 = (a) ListProtector.get(r3, r18);
    L7:
        if (r4 == null) goto L11;
        r1.getClass();
        List<b> r6 = r4.c;
        if (r6 == null) goto L11;
        int r7 = r6.size();
    L12:
        ItemGroup r8 = r1.b.c;
        if (r7 == r1.c) goto L22;
        r8.removeAllViews();
        if (r4 == null) goto L22;
        List<b> r9 = r4.c;
        if (r9 == null) goto L22;
        Iterator<T> r10 = r9.iterator();
    L20:
        if (r10.hasNext() == false) goto L22;
        b r11 = (b) r10.next();
        r8.addView(new ItemTextSelectorSubTitle(r1.a.getContext()));
    L22:
        TextView r12 = r1.b.b;
        Application r13 = AppHost.a.getApplication();
        Object[] r14 = new Object[1];
        if (r4 == null) goto L25;
        String r15 = r4.a;
    L27:
        if (r15 != null) goto L29;
        r15 = "";
    L29:
        r14[0] = r15;
        r12.setText(r13.getString(2131908014, r14));
        if (r4 == null) goto L34;
        Integer r16 = r4.b;
        if (r16 == null) goto L34;
        final int r19 = r16.intValue();
    L35:
        if (r4 == null) goto L37;
        List<b> r5 = r4.c;
    L38:
        Iterator r20 = ViewGroupKt.getChildren(r8).iterator();
        int r21 = 0;
    L40:
        if (r20.hasNext() == false) goto L79;
        Object r110 = r20.next();
        int r111 = r21 + 1;
        if (r21 >= 0) goto L44;
        CollectionsKt.throwIndexOverflow();
    L44:
        View r112 = (View) r110;
        if ((r112 instanceof ItemTextSelectorSubTitle) == false) goto L47;
        ItemTextSelectorSubTitle r113 = (ItemTextSelectorSubTitle) r112;
    L48:
        if (r5 == null) goto L50;
        final b r22 = (b) CollectionsKt.getOrNull(r5, r21);
    L51:
        if (r113 == null) goto L58;
        if (r22 == null) goto L54;
        String r114 = r22.b;
    L55:
        if (r114 != null) goto L57;
        r114 = "";
    L57:
        r113.setTitle(r114);
        goto L58
    L54:
        r114 = null;
    L58:
        if (r22 == null) goto L60;
        int r115 = r22.d;
    L61:
        if (r115 == 0) goto L74;
        if (r115 != 1) goto L64;
        if (r113 == null) goto L70;
        r113.setSelected(true);
    L70:
        if (r113 == null) goto L78;
        r113.R5();
    L78:
        r112.setOnClickListener(new dt9.a(r22, r2, r19));
        r21 = r111;
        goto L40
    L64:
        if (r115 != 2) goto L78;
        if (r113 == null) goto L78;
        LarusItemMusicAccountBinding r23 = r113.getBinding();
        r23.d.setAlpha(0.0f);
        r23.b.setAlpha(1.0f);
        r113.getBinding().a.postInvalidate();
        goto L78
    L74:
        if (r113 == null) goto L76;
        r113.setSelected(false);
    L76:
        if (r113 == null) goto L78;
        r113.R5();
        goto L78
    L60:
        r115 = 0;
        goto L61
    L50:
        r22 = null;
        goto L51
    L47:
        r113 = null;
        goto L48
    L79:
        r1.c = r7;
        return;
    L37:
        r5 = null;
    L34:
        r19 = -1;
        goto L35
    L25:
        r15 = null;
    L11:
        r7 = 0;
        goto L12
    L5:
        r4 = null;
        goto L7
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        View r6 = LayoutInflater.from(r4.getContext()).inflate(2131562472, r4, false);
        LinearLayout r7 = (LinearLayout) r6;
        int r0 = 2131385773;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r6, 2131385773);
        if (r1 == null) goto L9;
        r0 = 2131388572;
        ItemGroup r2 = ViewBindings.findChildViewById(r6, 2131388572);
        if (r2 == null) goto L9;
        return new ThirdPartyViewHolder(r7, new LarusItemAccountGroupBinding(r7, r1, r2));
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r0)));
    }
}
