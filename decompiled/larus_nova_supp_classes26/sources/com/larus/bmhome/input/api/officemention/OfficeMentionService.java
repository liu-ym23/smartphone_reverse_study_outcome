package com.larus.bmhome.input.api.officemention;

import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputMentionPanelController;
import com.larus.bmhome.share.panel.ShareType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import qp8.a;
import qp8.b;
import qp8.c;
import qp8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0013\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J+\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u0096\u0001J!\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0096\u0001J\u0019\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0016H\u0096\u0001J\u0019\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001bH\u0096\u0001J\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\u0011\u001a\u00020\u0012H\u0096A¢\u0006\u0002\u0010#J \u0010$\u001a\u0004\u0018\u00010\u001b2\u0006\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u001bH\u0096A¢\u0006\u0002\u0010'J\u0018\u0010(\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001f\u001a\u00020\u001bH\u0096\u0001¢\u0006\u0002\u0010)¨\u0006*"}, d2 = {"Lcom/larus/bmhome/input/api/officemention/OfficeMentionService;", "Lcom/larus/bmhome/input/api/officemention/IOfficeMentionService;", "<init>", "()V", "clearContactAvatar", "", "imageView", "Landroid/widget/ImageView;", "createEditor", "Lcom/larus/bmhome/input/api/officemention/IOfficeMentionEditor;", "editText", "Landroid/widget/EditText;", "createPanelController", "Lcom/larus/bmhome/input/api/officemention/IOfficeMentionPanelController;", "editor", "panelContainer", "Landroid/view/ViewGroup;", "config", "Lcom/larus/bmhome/input/api/officemention/OfficeMentionPanelConfig;", "callback", "Lcom/larus/bmhome/input/api/officemention/OfficeMentionPanelCallback;", "inputLayoutResource", "", "isSupported", "", "loadContactAvatar", "avatarKey", "", "entityId", "loadDocumentIcon", "objType", ShareType.URL, "loadRecommendedContacts", "", "Lcom/larus/bmhome/input/api/officemention/OfficeMentionContact;", "(Lcom/larus/bmhome/input/api/officemention/OfficeMentionPanelConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveContactOpenId", "userId", "appId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveDocumentObjType", "(Ljava/lang/String;)Ljava/lang/Integer;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeMentionService implements IOfficeMentionService {
    public static final OfficeMentionService b = null;
    public final /* synthetic */ IOfficeMentionService a;

    static {
        b = new OfficeMentionService();
    }

    @Override // com.larus.bmhome.input.api.officemention.IOfficeMentionService
    public final void e(ImageView r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "imageView");
        Intrinsics.checkNotNullParameter(r3, ShareType.URL);
        this.a.e(r2, r3);
    }

    @Override // com.larus.bmhome.input.api.officemention.IOfficeMentionService
    public final void f(ImageView r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "imageView");
        Intrinsics.checkNotNullParameter(r3, "avatarKey");
        Intrinsics.checkNotNullParameter(r4, "entityId");
        this.a.f(r2, r3, r4);
    }

    @Override // com.larus.bmhome.input.api.officemention.IOfficeMentionService
    public final Object g(String r2, String r3, Continuation<? super String> r4) {
        return this.a.g(r2, r3, r4);
    }

    @Override // com.larus.bmhome.input.api.officemention.IOfficeMentionService
    public final void h(ImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "imageView");
        this.a.h(r2);
    }

    @Override // com.larus.bmhome.input.api.officemention.IOfficeMentionService
    public final a i(EditText r2) {
        Intrinsics.checkNotNullParameter(r2, "editText");
        return this.a.i(r2);
    }

    @Override // com.larus.bmhome.input.api.officemention.IOfficeMentionService
    public final boolean isSupported() {
        return this.a.isSupported();
    }

    @Override // com.larus.bmhome.input.api.officemention.IOfficeMentionService
    public final Object j(e r2, Continuation<? super List<c>> r3) {
        return this.a.j(r2, r3);
    }

    @Override // com.larus.bmhome.input.api.officemention.IOfficeMentionService
    public final int k() {
        return this.a.k();
    }

    @Override // com.larus.bmhome.input.api.officemention.IOfficeMentionService
    public final void l(ImageView r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "imageView");
        this.a.l(r2, r3);
    }

    @Override // com.larus.bmhome.input.api.officemention.IOfficeMentionService
    public final Integer m(String r2) {
        Intrinsics.checkNotNullParameter(r2, ShareType.URL);
        return this.a.m(r2);
    }

    @Override // com.larus.bmhome.input.api.officemention.IOfficeMentionService
    public final b n(a r2, ViewGroup r3, e r4, ChatInputMentionPanelController.a r5) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        Intrinsics.checkNotNullParameter(r3, "panelContainer");
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, "callback");
        return this.a.n(r2, r3, r4, r5);
    }

    private OfficeMentionService() {
        IOfficeMentionService r0 = (IOfficeMentionService) ServiceManager.get().getService(IOfficeMentionService.class);
        if (r0 != null) goto L5;
        r0 = new OfficeMentionServiceNoop();
    L5:
        this.a = r0;
    }
}
