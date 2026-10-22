package com.ss.android.lark.chatwindow.view.photopreview;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import b7b.b;
import com.bytedance.supervisor.token.Token;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.auditsdk.v2.utils.AuditUtilsV2;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.bundle.SourceType;
import com.ss.android.lark.chat.constant.ChatFromType;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.media.MediaExtra;
import com.ss.android.lark.chat.entity.media.MediaImageSet;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.chat.utils.IMRichTextCopyUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.photo.preview.callback.OperateListener;
import com.ss.android.lark.widget.photo.preview.intercept.Interceptors;
import com.ss.android.lark.widget.photo.preview.utils.c;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.richtext.Image;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import w4b.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class OperateListenerImpl implements OperateListener {
    private Chat mChat;
    private String mChatId;

    public class a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ PhotoItem b;
        public final /* synthetic */ OperateListenerImpl c;

        @Override // java.lang.Runnable
        public final void run() {
            OperateListenerImpl.access$000(this.c, this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(OperateListenerImpl r1, Context r2, PhotoItem r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public OperateListenerImpl(Chat r2) {
        if (r2 == null) goto L5;
        this.mChatId = r2.getId();
    L5:
        this.mChat = r2;
    }

    public OperateListenerImpl(String r1) {
        this.mChatId = r1;
    }

    public static void a(Context r15, PhotoItem r16) {
        if (r16 != null) goto L6;
        Log.e("OperateListenerImpl", "copyPhotoItem failed, photoItem is null");
        return;
    L6:
        int r1 = c.a;
        Intrinsics.checkNotNullParameter(r16, "photoItem");
        boolean r3 = false;
        if (r16.isVideo() == false) goto L13;
        MediaImageSet r2 = new MediaImageSet();
        if (r16.getType() != 3) goto L11;
        boolean r4 = true;
    L12:
        r2.setMessageIdentity(r16.getMessageIdentity());
        r2.setKey(r16.getToken());
        r2.setOrigin(c.a(r16.getOriginPicInfo(), r4));
        r2.setMiddle(c.a(r16.getOriginPicInfo(), r4));
        r2.setThumbnail(c.a(r16.getThumbnailPicInfo(), r4));
        r2.setMediaExtra(r16.getMediaExtra());
        ImageSet r5 = r2;
    L18:
        int r0 = o7b.a.a;
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r5, "imageSet");
        MessageIdentity r6 = r5.getMessageIdentity();
        if (r6 != null) goto L21;
        Log.e("ChatPhotoPreviewCopyHandler", "copyPhotoItem failed, messageIdentity is null");
        return;
    L21:
        SpannableStringBuilder r7 = new SpannableStringBuilder();
        RichTextElement r8 = new RichTextElement();
        boolean r9 = r5 instanceof MediaImageSet;
        String r10 = BuildConfig.FLAVOR;
        if (r9 == false) goto L49;
        r8.setTag(RichTextElement.RichTextTag.MEDIA);
        MediaImageSet r11 = (MediaImageSet) r5;
        RichTextElement.MediaProperty r12 = new RichTextElement.MediaProperty();
        Image r13 = o7b.a.a(r11.getOrigin());
        MediaExtra r14 = r11.getMediaExtra();
        r12.setOriginImage(r13);
        String r17 = r11.getOrigin().getKey();
        if (r17 != null) goto L26;
    L29:
        boolean r18 = true;
    L30:
        if (r18 == true) goto L40;
        MatchResult r19 = new Regex(":(.*)").find(r17, 0);
        if (r19 == null) goto L39;
        MatchGroup r20 = r19.getGroups().get(1);
        if (r20 == null) goto L39;
        r10 = r20.getValue();
        if (r10 != null) goto L40;
    L39:
        r10 = r17;
    L40:
        r12.setCryptoToken(r10);
        r12.setDuration((int) r14.getDuration());
        r12.setKey(r14.getKey());
        r12.setUrl(r14.getUrl());
        r12.setMime(r14.getMime());
        if (r13 == null) goto L43;
        int r21 = r13.getWidth();
    L44:
        r12.setWidth(r21);
        if (r13 == null) goto L47;
        int r22 = r13.getHeight();
    L48:
        r12.setHeight(r22);
        r12.setImageSetKey(r11.getKey());
        r7.append(UIHelper.getString(2131891923));
    L71:
        r8.setProperty(r12);
        RichText r23 = com.ss.android.lark.widget.richtext.c.b(CollectionsKt.listOf(r8));
        if ((!Intrinsics.areEqual(r6.getSenderId(), ChatCoreModule.a().getPassportDependency().userId())) == true) goto L75;
        Lazy r24 = AuditUtilsV2.a;
        if (AuditUtilsV2.b() == true) goto L75;
    L76:
        List r25 = r23.getImageIds();
        if (r25 != null) goto L79;
    L82:
        boolean r26 = true;
    L83:
        if (r26 == false) goto L93;
        List r27 = r23.getMediaIds();
        if (r27 != null) goto L87;
    L90:
        boolean r28 = true;
    L91:
        if (r28 == false) goto L93;
        r3 = true;
        goto L93
    L87:
        if (r27.isEmpty() == true) goto L90;
        r28 = false;
    L93:
        b.b(r15, IMRichTextCopyUtils.j(r7, r23), r23, r6.getMessageId(), new Token("LARK-PSDA-photo-preview-copy-image"), !r3);
        return;
    L79:
        if (r25.isEmpty() == true) goto L82;
        r26 = false;
    L75:
        Log.i("ChatPhotoPreviewCopyHandler", "hasCopyImageAuthorization is false, remove image");
        IMRichTextCopyUtils r29 = IMRichTextCopyUtils.a;
        Intrinsics.checkNotNull(r23);
        r29.b(r23, null);
        goto L76
    L47:
        r22 = 0;
        goto L48
    L43:
        r21 = 0;
        goto L44
    L26:
        if (r17.length() == 0) goto L29;
        r18 = false;
        goto L30
    L49:
        r8.setTag(RichTextElement.RichTextTag.IMG);
        r12 = new RichTextElement.ImageProperty();
        String r110 = r5.getKey();
        com.ss.android.lark.image.entity.Image r111 = r5.getOrigin();
        if (r111 == null) goto L52;
        int r112 = r111.getWidth();
    L53:
        com.ss.android.lark.image.entity.Image r113 = r5.getOrigin();
        if (r113 == null) goto L56;
        int r114 = r113.getHeight();
    L57:
        r12.setToken(r110);
        r12.setOriginHeight(r114);
        r12.setOriginWidth(r112);
        r12.setWidth(r112);
        r12.setHeight(r114);
        r12.setOriginSource(false);
        com.ss.android.lark.image.entity.Image r115 = r5.getOrigin();
        if (r115 == null) goto L60;
        String r116 = r115.getKey();
    L61:
        if (r116 != null) goto L63;
        r116 = BuildConfig.FLAVOR;
    L63:
        r12.setOriginKey(r116);
        com.ss.android.lark.image.entity.Image r117 = r5.getMiddle();
        if (r117 == null) goto L66;
        String r118 = r117.getKey();
    L67:
        if (r118 == null) goto L70;
        r10 = r118;
    L70:
        r12.setMiddleKey(r10);
        r12.setMiddleImage(o7b.a.a(r5.getMiddle()));
        r12.setThumbImage(o7b.a.a(r5.getThumbnail()));
        r7.append(UIHelper.getString(2131891845));
        goto L71
    L66:
        r118 = null;
        goto L67
    L60:
        r116 = null;
        goto L61
    L56:
        r114 = 0;
        goto L57
    L52:
        r112 = 0;
        goto L53
    L11:
        r4 = false;
        goto L12
    L13:
        ImageSet r30 = new ImageSet();
        if (r16.getType() != 3) goto L16;
        boolean r31 = true;
    L17:
        r30.setMessageIdentity(r16.getMessageIdentity());
        r30.setKey(r16.getImageKey());
        r30.setOrigin(c.a(r16.getOriginPicInfo(), r31));
        r30.setMiddle(c.a(r16.getOriginPicInfo(), r31));
        r30.setThumbnail(c.a(r16.getThumbnailPicInfo(), r31));
        r5 = r30;
        goto L18
    L16:
        r31 = false;
        goto L17
    }

    public static /* synthetic */ void access$000(OperateListenerImpl r0, Context r1, PhotoItem r2) {
        r0.getClass();
        a(r1, r2);
    }

    public void onOperate(Context r5, String r6, PhotoItem r7, boolean r8) {
        r6.getClass();
        int r9 = r6.hashCode();
        if (r9 == (-318303349)) goto L18;
        if (r9 == 67343016) goto L14;
        if (r9 == 822382577) goto L10;
    L19:
        byte r10 = -1;
    L22:
        if (r10 == 0) goto L35;
        if (r10 == 1) goto L31;
        if (r10 == 2) goto L27;
        return;
    L27:
        if ((r5 instanceof Activity) == false) goto L29;
        Interceptors.d((LifecycleOwner) r5, r5, "COPY_IMAGE", r7, new a(this, r5, r7));
        return;
    L29:
        a(r5, r7);
        return;
    L31:
        if (this.mChat != null) goto L33;
        Log.e("OperateListenerImpl", "openChatAlbum failed, chat is null");
        return;
    L33:
        ChatCoreModule.a().getChatDependency().n(r5);
        return;
    L35:
        if (TextUtils.isEmpty(this.mChatId) == true) goto L39;
        if (r7 == null) goto L39;
        g r11 = ChatCoreModule.a().getChatDependency();
        ChatBundle.a r12 = new ChatBundle.a();
        r12.a = this.mChatId;
        r12.h = SourceType.SEARCH;
        r12.g = r7.getMessageId();
        r12.d = ChatFromType.GALLERY;
        r11.openChat(r5, new ChatBundle(r12));
        return;
    L39:
        Log.e("OperateListenerImpl", "openChat failed, chatId or photoItem is null");
        return;
    L10:
        if (r6.equals("COPY_IMAGE") == false) goto L19;
        r10 = 2;
        goto L22
    L14:
        if (r6.equals("CHAT_ALBUM") == false) goto L19;
        r10 = 1;
        goto L22
    L18:
        if (r6.equals("JUMP_TO_CHAT") == false) goto L19;
        r10 = 0;
        goto L22
    }
}
