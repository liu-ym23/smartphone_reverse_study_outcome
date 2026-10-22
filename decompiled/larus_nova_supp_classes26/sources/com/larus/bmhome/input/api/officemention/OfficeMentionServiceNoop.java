package com.larus.bmhome.input.api.officemention;

import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputMentionPanelController;
import com.larus.bmhome.share.panel.ShareType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import qp8.a;
import qp8.b;
import qp8.c;
import qp8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J \u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0016J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0013H\u0016J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\u0018\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u0013H\u0016J\u0017\u0010!\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020\u0013H\u0016¢\u0006\u0002\u0010\"J*\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010(\u001a\u00020)H\u0016¨\u0006*"}, d2 = {"Lcom/larus/bmhome/input/api/officemention/OfficeMentionServiceNoop;", "Lcom/larus/bmhome/input/api/officemention/IOfficeMentionService;", "<init>", "()V", "isSupported", "", "inputLayoutResource", "", "createEditor", "Lcom/larus/bmhome/input/api/officemention/IOfficeMentionEditor;", "editText", "Landroid/widget/EditText;", "loadRecommendedContacts", "", "Lcom/larus/bmhome/input/api/officemention/OfficeMentionContact;", "config", "Lcom/larus/bmhome/input/api/officemention/OfficeMentionPanelConfig;", "(Lcom/larus/bmhome/input/api/officemention/OfficeMentionPanelConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveContactOpenId", "", "userId", "appId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadContactAvatar", "", "imageView", "Landroid/widget/ImageView;", "avatarKey", "entityId", "clearContactAvatar", "loadDocumentIcon", "objType", ShareType.URL, "resolveDocumentObjType", "(Ljava/lang/String;)Ljava/lang/Integer;", "createPanelController", "Lcom/larus/bmhome/input/api/officemention/IOfficeMentionPanelController;", "editor", "panelContainer", "Landroid/view/ViewGroup;", "callback", "Lcom/larus/bmhome/input/api/officemention/OfficeMentionPanelCallback;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeMentionServiceNoop implements IOfficeMentionService {
    public OfficeMentionServiceNoop() {
    }

    @Override // com.larus.bmhome.input.api.officemention.IOfficeMentionService
    public final Object g(String r1, String r2, Continuation<? super String> r3) {
        return null;
    }

    @Override // com.larus.bmhome.input.api.officemention.IOfficeMentionService
    public final a i(EditText r2) {
        Intrinsics.checkNotNullParameter(r2, "editText");
        return null;
    }

    @Override // com.larus.bmhome.input.api.officemention.IOfficeMentionService
    public final boolean isSupported() {
        return false;
    }

    @Override // com.larus.bmhome.input.api.officemention.IOfficeMentionService
    public final int k() {
        return 0;
    }

    @Override // com.larus.bmhome.input.api.officemention.IOfficeMentionService
    public final Integer m(String r2) {
        Intrinsics.checkNotNullParameter(r2, ShareType.URL);
        return null;
    }

    @Override // com.larus.bmhome.input.api.officemention.IOfficeMentionService
    public final b n(a r2, ViewGroup r3, e r4, ChatInputMentionPanelController.a r5) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        Intrinsics.checkNotNullParameter(r3, "panelContainer");
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, "callback");
        return null;
    }

    @Override // com.larus.bmhome.input.api.officemention.IOfficeMentionService
    public final void h(ImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "imageView");
        r2.setImageDrawable(null);
    }

    @Override // com.larus.bmhome.input.api.officemention.IOfficeMentionService
    public final void e(ImageView r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "imageView");
        Intrinsics.checkNotNullParameter(r3, ShareType.URL);
        r2.setImageDrawable(null);
    }

    @Override // com.larus.bmhome.input.api.officemention.IOfficeMentionService
    public final Object j(e r1, Continuation<? super List<c>> r2) {
        return CollectionsKt.emptyList();
    }

    @Override // com.larus.bmhome.input.api.officemention.IOfficeMentionService
    public final void l(ImageView r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "imageView");
        r1.setImageDrawable(null);
    }

    @Override // com.larus.bmhome.input.api.officemention.IOfficeMentionService
    public final void f(ImageView r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "imageView");
        Intrinsics.checkNotNullParameter(r3, "avatarKey");
        Intrinsics.checkNotNullParameter(r4, "entityId");
        r2.setImageDrawable(null);
    }
}
