package com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler;

import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.home.impl.sdk.n1;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ic8.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class DocApplyPermissionSceneHandler extends c {
    public final String a;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/commonbuttonv2/scenehandler/DocApplyPermissionSceneHandler$Docs;", "Ljava/io/Serializable;", ShareType.URL, "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Docs implements Serializable {

        @SerializedName(ShareType.URL)
        private final String url;

        public Docs() {
            String r0 = null;
            this(r0, 1, r0);
        }

        public static /* synthetic */ Docs copy$default(Docs r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.url;
        L6:
            return r0.copy(r1);
        }

        public final String component1() {
            return this.url;
        }

        public final Docs copy(String r2) {
            return new Docs(r2);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof Docs) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.url, ((Docs) r4).url) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            String r0 = this.url;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "Docs(url=" + this.url + ')';
        }

        public final String getUrl() {
            return this.url;
        }

        public Docs(String r1) {
            this.url = r1;
        }

        public /* synthetic */ Docs(String r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }
    }

    public static final class a {
    }

    static {
    }

    public DocApplyPermissionSceneHandler() {
        this.a = "document_apply_permission";
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final String getScene() {
        return this.a;
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.c, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final void a(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r8) {
        Intrinsics.checkNotNullParameter(r8, "vmData");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new DocApplyPermissionSceneHandler$onClick$1(this, r8, null), 2, null);
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.c, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final boolean c(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r6) {
        Intrinsics.checkNotNullParameter(r6, "vmData");
        Map<String, String> r7 = r6.h;
        if (r7 == null) goto L5;
        String r8 = r7.get("entry_status");
    L6:
        boolean r9 = !Intrinsics.areEqual(r8, "can_apply");
        boolean r1 = AccountService.a.isLogin().booleanValue();
        FLogger.a.i("[DocTracer]", "needHideButton, cannotApply: " + r9 + ", isLogin: " + r1);
        if (r9 == true) goto L12;
        if (r1 == false) goto L13;
        return false;
    L13:
        return true;
    L12:
        return true;
    L5:
        r8 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.c, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final void d(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r8) {
        Intrinsics.checkNotNullParameter(r8, "vmData");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new DocApplyPermissionSceneHandler$onShow$1(this, r8, null), 2, null);
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.c, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final Integer g(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r2) {
        Intrinsics.checkNotNullParameter(r2, "vmData");
        IFlowSdkDepend r3 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r3 == null) goto L5;
        r3.N();
        return n1.a.n();
    L5:
        return null;
    }

    public static final String i(DocApplyPermissionSceneHandler r1, Message r2) {
        r1.getClass();
        if (r2 == null) goto L5;
        String r3 = r2.getConversationId();
    L7:
        if (r3 != null) goto L10;
        r3 = "";
    L10:
        if (r3.length() != 0) goto L12;
        boolean r0 = true;
    L13:
        if (r0 == true) goto L23;
        wc9.e r4 = (wc9.e) ko8.a.a.get(r3);
        if (r4 == null) goto L22;
        String r5 = n.f(r4);
        if (r5 != null) goto L21;
        return "";
    L21:
        return r5;
    L22:
        return "";
    L23:
        return "";
    L12:
        r0 = false;
        goto L13
    L5:
        r3 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.ArrayList] */
    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.c, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final void h(com.bytedance.router.i r7, com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r8) {
        Intrinsics.checkNotNullParameter(r7, "route");
        Intrinsics.checkNotNullParameter(r8, "vmData");
        Map<String, String> r0 = r8.h;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.get("docs");
    L30:
    L10:
        e = move-exception;
        FLogger.a.e("[DocTracer]", "getSuggestPromptExtra error >>> " + e);
    L12:
        Docs[] r3 = null;
    L13:
        if (r3 == null) goto L20;
        List r4 = new ArrayList();
        int r5 = r3.length;
        int r6 = 0;
    L15:
        if (r6 >= r5) goto L21;
        String r9 = r3[r6].getUrl();
        if (r9 == null) goto L19;
        r4.add(r9);
    L19:
        r6 = r6 + 1;
    L21:
        ArrayList<String> r10 = new ArrayList(r4);
        Bundle r11 = new Bundle();
        r11.putStringArrayList("apply_permission_urls", r10);
        Message r12 = r8.i;
        if (r12 == null) goto L24;
        String r13 = r12.getMessageId();
    L25:
        r11.putString(MusicAppletPage.KEY_MESSAGE_ID, r13);
        Message r14 = r8.i;
        if (r14 == null) goto L28;
        r1 = r14.getConversationId();
    L28:
        r11.putString(MusicAppletPage.KEY_CONVERSATION_ID, r1);
        r7.g(r11);
        return;
    L24:
        r13 = null;
        goto L25
    L20:
        r4 = CollectionsKt.emptyList();
        goto L21
    L7:
        if (o0.d(r2) == false) goto L12;
        r3 = (Docs[]) new Gson().fromJson(r2, Docs[].class);     // Catch: Exception -> L10
        goto L13
    L5:
        r2 = null;
        goto L30
    }
}
