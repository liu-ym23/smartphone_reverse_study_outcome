package com.larksuite.component.blockit.hashtag.add;

import com.alibaba.fastjson.JSON;
import com.larksuite.component.blockit.entity.BatchTagActionRequest;
import com.larksuite.component.blockit.entity.BlockEntity;
import com.larksuite.component.blockit.entity.BlockInfo;
import com.larksuite.component.blockit.entity.CreateTagAndAddItemRequest;
import com.larksuite.component.blockit.entity.SearchTagViewRequest;
import com.larksuite.component.blockit.entity.SearchTagsRequest;
import com.larksuite.component.blockit.entity.TagPermissionType;
import com.larksuite.component.blockit.entity.TagScene;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.http.request.HttpMethod;
import com.larksuite.framework.http.request.RequestBody;
import com.larksuite.framework.mvp.BaseModel;
import com.ss.android.lark.log.Log;
import java.util.Collections;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a extends BaseModel implements i {
    public final BlockEntity a;

    @Override // com.larksuite.framework.mvp.BaseModel, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
    }

    public a(BlockEntity r1) {
        this.a = r1;
    }

    @Override // com.larksuite.component.blockit.hashtag.add.i
    public final void P7(String r4, final UIGetDataCallback r5) {
        Intrinsics.checkNotNullParameter(r4, "query");
        Intrinsics.checkNotNullParameter(r5, "callback");
        int r0 = oy7.a.d.a;
        BlockEntity r1 = this.a;
        if (r1 == null) goto L5;
        String r2 = r1.getBlockID();
    L6:
        IGetDataCallback r6 = (IGetDataCallback) getCallbackManager().wrapAndAddCallback(new AddHashTagModel$searchTags$1(this, r5));
        Log.i("HashTagService", "searchTags uniqueId: " + r2);
        SearchTagsRequest r3 = new SearchTagsRequest();
        r3.uniqueId = r2;
        r3.tagName = r4;
        r3.isPreciseSearch = false;
        String r7 = JSON.toJSONString(r3);
        z18.a r8 = new z18.a(HttpMethod.POST, oy7.a.b().concat("/api/SearchTags"));
        r8.e = RequestBody.create("application/json", r7);
        r8.b = ry7.a.a();
        r8.c(new oy7.c(r6));
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.larksuite.component.blockit.hashtag.add.i
    public final void G2(String r4, String r5, final UIGetDataCallback r6) {
        Intrinsics.checkNotNullParameter(r4, "tagId");
        Intrinsics.checkNotNullParameter(r6, "callback");
        int r0 = oy7.a.d.a;
        BlockEntity r1 = this.a;
        IGetDataCallback r7 = (IGetDataCallback) getCallbackManager().wrapAndAddCallback(new AddHashTagModel$addTag$1(r6));
        Log.i("HashTagService", "addTag:" + r4 + ":" + r1.getBlockID());
        BatchTagActionRequest.AddTagAction r2 = new BatchTagActionRequest.AddTagAction();
        r2.tagId = r4;
        r2.tagType = 1;
        BatchTagActionRequest.ItemTagAction r8 = new BatchTagActionRequest.ItemTagAction();
        r8.uniqId = r1.getBlockID();
        r8.blockInfo = new BlockInfo(r1);
        r8.tagsAdding = Collections.singletonList(r2);
        BatchTagActionRequest r3 = new BatchTagActionRequest();
        r3.itemsAction = Collections.singletonList(r8);
        r3.context = r5;
        oy7.a.a(r1.getBlockID(), r3, r7);
    }

    @Override // com.larksuite.component.blockit.hashtag.add.i
    public final void T4(String r4, String r5, final UIGetDataCallback r6) {
        Intrinsics.checkNotNullParameter(r4, "tagName");
        Intrinsics.checkNotNullParameter(r6, "callback");
        int r0 = oy7.a.d.a;
        BlockEntity r1 = this.a;
        IGetDataCallback r7 = (IGetDataCallback) getCallbackManager().wrapAndAddCallback(new AddHashTagModel$createTag$1(r6));
        Log.i("HashTagService", "createTag id: " + r1.getBlockID());
        CreateTagAndAddItemRequest r2 = new CreateTagAndAddItemRequest();
        r2.tagName = r4;
        r2.tagType = 1;
        r2.uniqId = r1.getBlockID();
        r2.blockInfo = new BlockInfo(r1);
        r2.context = r5;
        r2.permissionType = TagPermissionType.Private.value();
        r2.scene = TagScene.Default.value();
        String r8 = JSON.toJSONString(r2);
        z18.a r3 = new z18.a(HttpMethod.POST, oy7.a.b().concat("/api/CreateTagAndAddItem"));
        r3.e = RequestBody.create("application/json", r8);
        r3.b = ry7.a.a();
        r3.c(new oy7.b(r1, r7));
    }

    @Override // com.larksuite.component.blockit.hashtag.add.i
    public final void p3(String r3, String r4, final UIGetDataCallback r5) {
        Intrinsics.checkNotNullParameter(r3, "query");
        Intrinsics.checkNotNullParameter(r5, "callback");
        int r0 = oy7.a.d.a;
        IGetDataCallback r6 = (IGetDataCallback) getCallbackManager().wrapAndAddCallback(new AddHashTagModel$searchMentionTags$1(r5));
        Log.i("HashTagService", "SearchTagView");
        SearchTagViewRequest r1 = new SearchTagViewRequest();
        r1.userId = r4;
        r1.name = r3;
        r1.isPreciseSearch = false;
        String r7 = JSON.toJSONString(r1);
        String r8 = oy7.a.b().concat("/api/SearchTagView");
        z18.a r2 = new z18.a(HttpMethod.POST, r8);
        r2.e = RequestBody.create("application/json", r7);
        r2.b = ry7.a.a();
        r2.c(new oy7.d(r6));
    }
}
