package com.larus.uaigc.bean.chat.gallery;

import android.app.Activity;
import android.os.Bundle;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.Resource;
import com.larus.platform.model.creation.ResourceExt;
import com.larus.platform.service.z2;
import com.larus.uaigc.service.ICreationDetailImageEditService;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.utils.f;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ny9.b;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\\\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\nH\u0016J.\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u00132\u0006\u0010\u0018\u001a\u00020\nH\u0002JH\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u00172\u000e\u0010 \u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010!\u001a\u0004\u0018\u00010\b2\b\u0010\"\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\nH\u0002J\u001e\u0010#\u001a\u000e\u0012\b\u0012\u00060\u0012j\u0002`\u0013\u0018\u00010\u00052\b\u0010$\u001a\u0004\u0018\u00010\bH\u0002¨\u0006&"}, d2 = {"Lcom/larus/uaigc/bean/chat/gallery/CreationDetailImageEditServiceImpl;", "Lcom/larus/uaigc/service/ICreationDetailImageEditService;", "<init>", "()V", "buildSingleImageRefInfo", "", "Lcom/larus/platform/model/creation/ResourceExt;", "previewUrl", "", "openDetailEditPage", "", "activity", "Landroid/app/Activity;", "payload", "Lcom/larus/uaigc/bean/chat/gallery/CreationDetailImageEditHelper$DetailImagePayload;", "hitPointData", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/data/IInstructionHitPoint;", "actionBarItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "Lcom/larus/bmhome/view/actionbar/custom/bean/CustomActionBarItem;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "selectInstructionType", "", "openNewChatPage", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "ignoreSideBar", "pickImageEditItem", "Lcom/larus/uaigc/bean/chat/gallery/CreationDetailImageEditServiceImpl$TargetActionBarConfig;", "pickTargetActionBarConfig", "instructionType", "preferredItem", "currentBotId", "mainBotId", "getActionBarItems", "botId", "TargetActionBarConfig", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationDetailImageEditServiceImpl implements ICreationDetailImageEditService {

    public static final class a {
        public final z0 a;
        public final ChatParam b;
        public final boolean c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "TargetActionBarConfig(item=" + this.a + ", chatParam=" + this.b + ", openNewChatPage=" + this.c + ')';
        }

        public a(z0 r2, ChatParam r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "chatParam");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public CreationDetailImageEditServiceImpl() {
    }

    @Override // com.larus.uaigc.service.ICreationDetailImageEditService
    public final List<ResourceExt> a(String r24) {
        Intrinsics.checkNotNullParameter(r24, "previewUrl");
        if (StringsKt.isBlank(r24) == false) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return CollectionsKt.listOf(new ResourceExt(new Resource(1, new ImageInfo(null, new Image(r24, null, 0, 0, 30), new Image(r24, null, 0, 0, 30), null, null, null, null, null, null, 1017), null, 28), r24));
    }

    public static a c(int r14, z0 r15, ChatParam r16, String r17, String r18, boolean r19) {
        z0 r1 = r15;
        String r2 = r17;
        String r6 = null;
        if (r1 == null) goto L14;
        r r8 = r1.q;
        if (r8 != null) goto L7;
    L9:
        boolean r9 = false;
    L10:
        if (r9 == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L14;
    L47:
        if (r1 != null) goto L49;
        if (r18 != null) goto L58;
    L98:
        return null;
    L58:
        if (Intrinsics.areEqual(r18, r2) == true) goto L98;
        List r3 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).f(r18);
        if (r3 == null) goto L98;
        Iterator r4 = r3.iterator();
    L64:
        if (r4.hasNext() == false) goto L86;
        Object r5 = r4.next();
        z0 r10 = (z0) r5;
        r r11 = r10.q;
        if (r11 == null) goto L73;
        Integer r12 = r11.a;
        if (r12 == null) goto L73;
        if (r12.intValue() != r14) goto L73;
        boolean r13 = true;
    L74:
        if (r13 == false) goto L83;
        r r20 = r10.q;
        if (r20 != null) goto L78;
    L80:
        boolean r21 = false;
    L81:
        if (r21 == false) goto L83;
        boolean r22 = true;
    L84:
        if (r22 == false) goto L64;
    L87:
        z0 r23 = (z0) r5;
        if (r23 == null) goto L98;
        e r0 = (e) AuthModelDelegate.b.y().getValue();
        if (r0 == null) goto L93;
        r6 = r0.a;
    L93:
        if (r6 != null) goto L95;
        String r7 = "";
    L97:
        return new a(r23, new ChatParam(r7, r18, null, null, null, 252), true);
    L95:
        r7 = r6;
        goto L97
    L78:
        if (r20.f() != true) goto L80;
        r21 = true;
    L83:
        r22 = false;
    L73:
        r13 = false;
        goto L74
    L86:
        r5 = null;
        goto L87
    L49:
        if (r16 != null) goto L51;
        ChatParam r24 = new ChatParam(null, null, null, null, null, 255);
    L52:
        if (r2 != null) goto L55;
        r2 = r18;
    L55:
        return new a(r1, ChatParam.a(r24, null, r2, null, 253), r19);
    L51:
        r24 = r16;
        goto L52
    L7:
        if (r8.f() != true) goto L9;
        r9 = true;
    L14:
        IActionBarService r25 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r2 != null) goto L17;
        String r26 = "";
    L18:
        List r27 = r25.f(r26);
        if (r27 == null) goto L46;
        Iterator r28 = r27.iterator();
    L22:
        if (r28.hasNext() == false) goto L44;
        Object r29 = r28.next();
        z0 r30 = (z0) r29;
        r r110 = r30.q;
        if (r110 == null) goto L31;
        Integer r111 = r110.a;
        if (r111 == null) goto L31;
        if (r111.intValue() != r14) goto L31;
        boolean r112 = true;
    L32:
        if (r112 == false) goto L41;
        r r31 = r30.q;
        if (r31 != null) goto L36;
    L38:
        boolean r32 = false;
    L39:
        if (r32 == false) goto L41;
        boolean r33 = true;
    L42:
        if (r33 == false) goto L22;
    L45:
        r1 = (z0) r29;
        goto L47
    L36:
        if (r31.f() != true) goto L38;
        r32 = true;
    L41:
        r33 = false;
    L31:
        r112 = false;
        goto L32
    L44:
        r29 = null;
        goto L45
    L46:
        r1 = null;
        goto L47
    L17:
        r26 = r2;
        goto L18
    }

    @Override // com.larus.uaigc.service.ICreationDetailImageEditService
    public final boolean b(Activity r58, com.larus.uaigc.bean.chat.gallery.a.C0037a r59, zs8.a r60, z0 r61, ChatParam r62, int r63, boolean r64, by7.e r65, boolean r66) {
        Intrinsics.checkNotNullParameter(r58, "activity");
        Intrinsics.checkNotNullParameter(r59, "payload");
        Intrinsics.checkNotNullParameter(r60, "hitPointData");
        Boolean r2 = z2.a.getCreationEditControlConfig().b();
        Boolean r14 = Boolean.TRUE;
        if (Intrinsics.areEqual(r2, r14) == true) goto L5;
        return false;
    L5:
        z0 r9 = null;
        if (r62 == null) goto L8;
        String r10 = r62.b;
    L9:
        e0 r3 = (e0) AuthModelDelegate.b.e().getValue();
        if (r3 == null) goto L14;
        LaunchInfo r4 = r3.a;
        if (r4 == null) goto L14;
        String r12 = r4.W();
    L16:
        if (r61 == null) goto L28;
        r r5 = r61.q;
        if (r5 == null) goto L25;
        Integer r6 = r5.a;
        if (r6 == null) goto L25;
        if (r6.intValue() != 28) goto L25;
        boolean r7 = true;
    L26:
        if (r7 == false) goto L28;
        z0 r8 = r61;
    L29:
        a r11 = c(28, r8, r62, r10, r12, r64);
        if (r11 == null) goto L33;
    L46:
        if (r11 != null) goto L48;
        return false;
    L48:
        r r1 = r11.a.q;
        if (r1 != null) goto L51;
    L53:
        boolean r13 = false;
    L54:
        if (r13 == true) goto L56;
        return false;
    L56:
        ICreationWorkflowService.Companion r15 = ICreationWorkflowService.a;
        r r16 = r11.a.q;
        if (r16 == null) goto L64;
        Integer r17 = r16.a;
        if (r17 == null) goto L64;
        if (r17.intValue() != 28) goto L64;
        boolean r18 = true;
    L65:
        z0 r19 = r11.a;
        ChatParam r20 = r11.b;
        boolean r21 = r11.c;
        String r110 = r59.a;
        String r111 = r59.b;
        List<ResourceExt> r22 = r59.c;
        Integer r112 = Integer.valueOf(r63);
        Bundle r23 = f.c(new Pair[]{TuplesKt.to("is_prefilled_image", r14)});
        r23.putAll(r59.d);
        Unit r0 = Unit.INSTANCE;
        r15.f0(new b(r18, r58, r19, r20, r21, false, null, null, r110, r111, r22, null, null, r112, null, null, null, null, null, false, false, r60, r65, r23, false, null, null, null, false, null, r66, null, Boolean.FALSE, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1088431904, 262142));
        return true;
    L64:
        r18 = false;
        goto L65
    L51:
        if (r1.f() != true) goto L53;
        r13 = true;
        goto L54
    L33:
        if (r61 == null) goto L45;
        r r24 = r61.q;
        if (r24 == null) goto L42;
        Integer r25 = r24.a;
        if (r25 == null) goto L42;
        if (r25.intValue() != 4) goto L42;
        boolean r26 = true;
    L43:
        if (r26 == false) goto L45;
        r9 = r61;
    L42:
        r26 = false;
    L45:
        r11 = c(4, r9, r62, r10, r12, r64);
    L25:
        r7 = false;
    L28:
        r8 = null;
    L14:
        r12 = null;
        goto L16
    L8:
        r10 = null;
        goto L9
    }
}
