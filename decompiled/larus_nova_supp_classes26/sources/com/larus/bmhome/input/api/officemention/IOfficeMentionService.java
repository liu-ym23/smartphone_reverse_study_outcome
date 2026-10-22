package com.larus.bmhome.input.api.officemention;

import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputMentionPanelController;
import com.larus.bmhome.share.panel.ShareType;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import qp8.a;
import qp8.b;
import qp8.c;
import qp8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u000fJ \u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H¦@¢\u0006\u0002\u0010\u0014J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H&J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0005H&J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0011H&J\u0017\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u0011H&¢\u0006\u0002\u0010 J*\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'H&¨\u0006("}, d2 = {"Lcom/larus/bmhome/input/api/officemention/IOfficeMentionService;", "", "isSupported", "", "inputLayoutResource", "", "createEditor", "Lcom/larus/bmhome/input/api/officemention/IOfficeMentionEditor;", "editText", "Landroid/widget/EditText;", "loadRecommendedContacts", "", "Lcom/larus/bmhome/input/api/officemention/OfficeMentionContact;", "config", "Lcom/larus/bmhome/input/api/officemention/OfficeMentionPanelConfig;", "(Lcom/larus/bmhome/input/api/officemention/OfficeMentionPanelConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveContactOpenId", "", "userId", "appId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadContactAvatar", "", "imageView", "Landroid/widget/ImageView;", "avatarKey", "entityId", "clearContactAvatar", "loadDocumentIcon", "objType", ShareType.URL, "resolveDocumentObjType", "(Ljava/lang/String;)Ljava/lang/Integer;", "createPanelController", "Lcom/larus/bmhome/input/api/officemention/IOfficeMentionPanelController;", "editor", "panelContainer", "Landroid/view/ViewGroup;", "callback", "Lcom/larus/bmhome/input/api/officemention/OfficeMentionPanelCallback;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IOfficeMentionService {
    void e(ImageView r1, String r2);

    void f(ImageView r1, String r2, String r3);

    Object g(String r1, String r2, Continuation<? super String> r3);

    void h(ImageView r1);

    a i(EditText r1);

    boolean isSupported();

    Object j(e r1, Continuation<? super List<c>> r2);

    int k();

    void l(ImageView r1, int r2);

    Integer m(String r1);

    b n(a r1, ViewGroup r2, e r3, ChatInputMentionPanelController.a r4);
}
