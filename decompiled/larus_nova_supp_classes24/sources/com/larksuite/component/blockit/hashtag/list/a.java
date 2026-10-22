package com.larksuite.component.blockit.hashtag.list;

import android.text.TextUtils;
import com.larksuite.component.blockit.entity.BatchTagActionRequest;
import com.larksuite.component.blockit.entity.BlockEntity;
import com.larksuite.component.blockit.entity.BlockInfo;
import com.larksuite.component.blockit.entity.GrantRecord4Get;
import com.larksuite.component.blockit.entity.TagInstance;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.mvp.BaseModel;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.log.Log;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a extends BaseModel implements j {
    public final BlockEntity a;
    public final String b;

    @Override // com.larksuite.framework.mvp.BaseModel, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
    }

    public a(BlockEntity r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "blockEntity");
        this.a = r2;
        this.b = r3;
    }

    public static final String h(a r2, TagInstance.BasicTagInfo r3) {
        r2.getClass();
        String r0 = "";
        if (CollectionUtils.isEmpty(r3.owners) == true) goto L14;
        Iterator<GrantRecord4Get> r4 = r3.owners.iterator();
    L6:
        if (r4.hasNext() == false) goto L14;
        GrantRecord4Get r5 = r4.next();
        Map<String, String> r1 = r5.name;
        if (r1 == null) goto L6;
        if (CollectionUtils.isEmpty(r1.values()) == true) goto L6;
        r0 = r5.name.get(ry7.a.b());
        if (TextUtils.isEmpty(r0) == false) goto L6;
        r0 = (String) CollectionsKt.first(r5.name.values());
    L14:
        return r0;
    }

    @Override // com.larksuite.component.blockit.hashtag.list.j
    public final void B4(String r4, final UIGetDataCallback r5) {
        Intrinsics.checkNotNullParameter(r4, "blockId");
        Intrinsics.checkNotNullParameter(r5, "callback");
        int r0 = oy7.a.d.a;
        oy7.a.c(r4, true, true, this.b, (IGetDataCallback) getCallbackManager().wrapAndAddCallback(new HashTagListModel$loadAddedHashTags$1(this, r5)));
    }

    @Override // com.larksuite.component.blockit.hashtag.list.j
    public final void G7(String r5, String r6, final UIGetDataCallback r7) {
        Intrinsics.checkNotNullParameter(r5, "tagId");
        Intrinsics.checkNotNullParameter(r6, "tagInstanceId");
        Intrinsics.checkNotNullParameter(r7, "callback");
        int r0 = oy7.a.d.a;
        BlockEntity r1 = this.a;
        String r2 = this.b;
        IGetDataCallback r8 = (IGetDataCallback) getCallbackManager().wrapAndAddCallback(new HashTagListModel$deleteTag$1(this, r7));
        Log.i("HashTagService", "deleteTag:" + r5 + ":" + r1.getBlockID());
        BatchTagActionRequest.RemoveTagAction r3 = new BatchTagActionRequest.RemoveTagAction();
        r3.tagId = r5;
        r3.tagType = 1;
        r3.tagInstanceId = r6;
        BatchTagActionRequest.ItemTagAction r9 = new BatchTagActionRequest.ItemTagAction();
        r9.uniqId = r1.getBlockID();
        r9.blockInfo = new BlockInfo(r1);
        r9.tagsRemoving = Collections.singletonList(r3);
        BatchTagActionRequest r10 = new BatchTagActionRequest();
        r10.itemsAction = Collections.singletonList(r9);
        r10.context = r2;
        oy7.a.a(r1.getBlockID(), r10, r8);
    }
}
