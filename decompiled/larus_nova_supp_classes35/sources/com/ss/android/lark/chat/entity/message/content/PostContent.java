package com.ss.android.lark.chat.entity.message.content;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONType;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010 \u001a\u00020\u000bJ\b\u0010!\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'J\u0012\u0010(\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR.\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R6\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a0\u0019j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a`\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\"\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\t¨\u0006+"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/PostContent;", "Lcom/ss/android/lark/chat/entity/message/content/BaseTextContent;", "<init>", "()V", "title", BuildConfig.FLAVOR, "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "isNotified", BuildConfig.FLAVOR, "()Z", "setNotified", "(Z)V", "isGroupAnnouncement", "setGroupAnnouncement", "riskObjectKeys", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getRiskObjectKeys", "()Ljava/util/ArrayList;", "setRiskObjectKeys", "(Ljava/util/ArrayList;)V", "cleanResourceKeyScene", "Ljava/util/HashMap;", "Lcom/ss/android/lark/image/entity/ResourceCleanScene;", "Lkotlin/collections/HashMap;", "getCleanResourceKeyScene", "()Ljava/util/HashMap;", "setCleanResourceKeyScene", "(Ljava/util/HashMap;)V", "resourceIsCleaned", "firstResourceScene", "threadOwnerDisplayName", "getThreadOwnerDisplayName", "setThreadOwnerDisplayName", "getTitleWithFilter", "context", "Landroid/content/Context;", "isContentSame", "diffable", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JSONType(typeName = "PostContent")
public final class PostContent extends BaseTextContent<PostContent> {
    private HashMap<String, ResourceCleanScene> cleanResourceKeyScene;
    private boolean isGroupAnnouncement;
    private boolean isNotified;
    private ArrayList<String> riskObjectKeys;
    private String threadOwnerDisplayName;
    private String title;

    public final ResourceCleanScene firstResourceScene() {
        return (ResourceCleanScene) CollectionsKt.firstOrNull(this.cleanResourceKeyScene.values());
    }

    public final boolean resourceIsCleaned() {
        return !this.cleanResourceKeyScene.isEmpty();
    }

    public PostContent() {
        this.cleanResourceKeyScene = new HashMap();
        this.threadOwnerDisplayName = BuildConfig.FLAVOR;
    }

    public final HashMap<String, ResourceCleanScene> getCleanResourceKeyScene() {
        return this.cleanResourceKeyScene;
    }

    public final ArrayList<String> getRiskObjectKeys() {
        return this.riskObjectKeys;
    }

    public final String getThreadOwnerDisplayName() {
        return this.threadOwnerDisplayName;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isGroupAnnouncement() {
        return this.isGroupAnnouncement;
    }

    public final boolean isNotified() {
        return this.isNotified;
    }

    public final String getTitleWithFilter(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        if (TextUtils.isEmpty(this.title) == false) goto L5;
        return BuildConfig.FLAVOR;
    L5:
        Iterator r5 = ArrayIteratorKt.iterator(UIUtils.getStringArray(r4, 2130903105));
    L7:
        if (r5.hasNext() == false) goto L11;
        if (Intrinsics.areEqual((String) r5.next(), this.title) == false) goto L7;
        return BuildConfig.FLAVOR;
    L11:
        String r6 = this.title;
        if (r6 != null) goto L15;
        return BuildConfig.FLAVOR;
    L15:
        return r6;
    }

    @Override // com.ss.android.lark.chat.entity.message.content.BaseTextContent, com.ss.android.lark.chat.export.entity.message.Content
    public boolean isContentSame(Content r6) {
        if ((r6 instanceof PostContent) == true) goto L5;
        return false;
    L5:
        String r0 = this.title;
        if (r0 != null) goto L11;
        if (((PostContent) r6).title == null) goto L13;
        return false;
    L13:
        ArrayList<String> r1 = this.riskObjectKeys;
        Integer r2 = null;
        if (r1 == null) goto L16;
        Integer r3 = Integer.valueOf(r1.size());
    L17:
        PostContent r4 = (PostContent) r6;
        ArrayList<String> r5 = r4.riskObjectKeys;
        if (r5 == null) goto L21;
        r2 = Integer.valueOf(r5.size());
    L21:
        if (Intrinsics.areEqual(r3, r2) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.cleanResourceKeyScene, r4.cleanResourceKeyScene) == true) goto L27;
        return false;
    L27:
        if (super.isContentSame(r6) == true) goto L29;
        return false;
    L29:
        if (y28.a.c(getDocResult(), r4.getDocResult()) == false) goto L33;
        return true;
    L33:
        return false;
    L16:
        r3 = null;
        goto L17
    L11:
        if (Intrinsics.areEqual(r0, ((PostContent) r6).title) == true) goto L13;
        return false;
    }

    public final void setCleanResourceKeyScene(HashMap<String, ResourceCleanScene> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.cleanResourceKeyScene = r2;
    }

    public final void setGroupAnnouncement(boolean r1) {
        this.isGroupAnnouncement = r1;
    }

    public final void setNotified(boolean r1) {
        this.isNotified = r1;
    }

    public final void setRiskObjectKeys(ArrayList<String> r1) {
        this.riskObjectKeys = r1;
    }

    public final void setThreadOwnerDisplayName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.threadOwnerDisplayName = r2;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    @Override // com.ss.android.lark.chat.entity.message.content.BaseTextContent, com.ss.android.lark.chat.export.entity.message.Content
    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((Content) r1);
    }
}
