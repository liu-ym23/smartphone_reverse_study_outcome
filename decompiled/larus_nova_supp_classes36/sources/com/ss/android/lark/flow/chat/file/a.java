package com.ss.android.lark.flow.chat.file;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.ss.android.lark.biz.officesdk.im.file.FlowFilePreviewData;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.preview.entity.component.property.DocImageProperty;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.Url;
import com.ss.android.lark.export.entity.preview.UrlPreviewComponent;
import com.ss.android.lark.export.entity.preview.ext.UrlPreviewEntityExt;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import jza.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import mya.f;
import s2b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements f {
    public final Context a;
    public final CoroutineScope b;
    public final v c;
    public final b d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.file.a$a, reason: collision with other inner class name */
    public static final class C0022a {
    }

    public interface b {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b a();
    }

    static {
    }

    public final Context getContext() {
        return this.a;
    }

    public final boolean h(LKUIRoundableLayout r18, PreviewHangPoint r19, String r20) {
        Intrinsics.checkNotNullParameter(r18, "view");
        Intrinsics.checkNotNullParameter(r19, "previewHangPoint");
        Intrinsics.checkNotNullParameter(r20, "messageId");
        UrlPreviewComponent r0 = edb.b.a(r19);
        String r3 = null;
        if (r0 == null) goto L5;
        BaseProperty r1 = r0.getProperty();
    L7:
        if ((r1 instanceof DocImageProperty) == false) goto L9;
        DocImageProperty r4 = (DocImageProperty) r1;
    L11:
        if (r4 != null) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == false) goto L22;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r6 = this.d.a();
        if (r6 != null) goto L20;
        Log.e("FlowDriveUrlPreviewCard", "onImageClick, featureEnv is null");
    L21:
        return true;
    L20:
        BuildersKt.launch$default(this.b, Dispatchers.getMain().getImmediate(), null, new FlowDriveUrlPreviewCardClickActionHandler$onImageClick$1(r4, r20, r6, r6.f(), this, null), 2, null);
        goto L21
    L22:
        UrlCardPreviewEntity r7 = r19.getUrlCardPreviewEntity();
        if (r7 != null) goto L25;
        return false;
    L25:
        UrlPreviewEntityExt r8 = r7.getInlineEntity().getExt();
        if (r8 == null) goto L90;
        UrlPreviewEntityExt.DocInfo r9 = r8.getDocInfo();
        if (r9 == null) goto L91;
        final jza.b r10 = OfficeSDKManager.getHostGlobalService(jza.b.class);
        if (r10 != null) goto L33;
        return false;
    L33:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r11 = this.d.a();
        if (r11 == null) goto L38;
        d r12 = r11.a();
        if (r12 == null) goto L38;
        Chat r13 = r12.getChat();
    L39:
        if (r11 == null) goto L46;
        IMessageListViewModel r14 = r11.f();
        if (r14 == null) goto L46;
        MessageInfo r15 = r14.getMessageInfoById(r20);
        if (r15 == null) goto L46;
        Message r16 = r15.getMessage();
        if (r16 == null) goto L46;
    L47:
        if (r16 != null) goto L49;
    L51:
        Url r17 = r7.getInlineEntity().getUrl();
        if (r17 == null) goto L54;
        String r110 = r17.getAndroidUrl();
    L55:
        if (r110 != null) goto L57;
    L60:
        boolean r111 = true;
    L61:
        if (r111 == false) goto L63;
        r110 = null;
    L63:
        if (r110 != null) goto L82;
        Url r112 = r7.getInlineEntity().getUrl();
        if (r112 == null) goto L67;
        String r113 = r112.getUrl();
    L68:
        if (r113 != null) goto L70;
    L73:
        boolean r114 = true;
    L74:
        if (r114 == true) goto L77;
        r3 = r113;
    L77:
        if (r3 != null) goto L83;
        String r2 = r19.getUrl();
        if (r2 != null) goto L81;
        return false;
    L81:
        r3 = r2;
    L83:
        Long r115 = r9.getFileType();
        String r21 = r9.getFileName();
        if (r21 != null) goto L88;
        r21 = r7.getInlineEntity().getTitle();
        if (r21 != null) goto L88;
        r21 = "";
    L88:
        String r22 = r3;
        final FlowFilePreviewData r23 = FlowFilePreviewData.a(((c) this.g.getValue()).a(r20, r22, r21, r9.getFileToken(), r16, r13), FlowFilePreviewData.Source.DRIVE, null, null, r115, 317);
        ((c) this.g.getValue()).c(this.a, r23, new FlowDriveUrlPreviewCardClickActionHandler$onUrlCardClick$openPreview$1(r10, this, r23));
        return true;
    L70:
        if (r113.length() == 0) goto L73;
        r114 = false;
        goto L74
    L67:
        r113 = null;
        goto L68
    L82:
        r3 = r110;
        goto L83
    L57:
        if (r110.length() == 0) goto L60;
        r111 = false;
        goto L61
    L54:
        r110 = null;
        goto L55
    L49:
        if (((c) this.g.getValue()).b(this.a, r16, r13) == false) goto L51;
        return true;
    L46:
        r16 = ImSdkService.f().ta(CollectionsKt.listOf(r20)).get(r20);
    L38:
        r13 = null;
        goto L39
    L91:
        return false;
    L90:
        return false;
    L13:
        if (r4.getSupportPreview() != true) goto L15;
        r5 = true;
        goto L16
    L9:
        r4 = null;
        goto L11
    L5:
        r1 = null;
        goto L7
    }

    public a(FragmentActivity r2, LifecycleCoroutineScope r3, v r4, b r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "chatAppContainer");
        Intrinsics.checkNotNullParameter(r5, "messageListFeatureAbility");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = LazyKt.lazy(FlowDriveUrlPreviewCardClickActionHandler$openFeishuGalleryPreviewDependency$2.INSTANCE);
        this.f = LazyKt.lazy(new FlowDriveUrlPreviewCardClickActionHandler$mediaPreviewObserverManager$2(this));
        this.g = LazyKt.lazy(FlowDriveUrlPreviewCardClickActionHandler$fileSecurityService$2.INSTANCE);
    }
}
