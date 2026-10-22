package com.ss.android.lark.chat.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.base.view.vo.message.MediaContentVO;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.media.MediaImageSet;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d0 {
    public static boolean c(y6b.a<MediaContentVO> r2) {
        boolean r0 = false;
        if (r2 == null) goto L11;
        String r3 = r2.b().f();
        if (TextUtils.isEmpty(r3) == true) goto L11;
        VFSFile r4 = VFSFiles.b.i(r3);
        if (r4.exists() == false) goto L11;
        if (r4.canRead() == true) goto L11;
        r0 = true;
    L11:
        Log.i("MediaUtil", "needRequestReadVideoPermission:" + r0);
        return r0;
    }

    public static void b(final FragmentActivity r16, final View r17, final y6b.a r18, final b3b.j r19, final mya.h r20) {
        if (ChatCoreModule.a().getLoginDependency().a(r18.g()) == true) goto L5;
        a(r16, r17, r18, false, r19, r20, null, null);
        return;
    L5:
        if ((r16 instanceof Activity) == true) goto L7;
        return;
    L7:
        if (c(r18) == false) goto L9;
        com.ss.android.lark.utils.h.f(r16, new c0(r18, r16, r17, r19, r20), com.ss.android.lark.utils.n.b(), new Token("LARK-PSDA-android_photo_picker_request_permission"), 4, new String[0]);
        return;
    L9:
        a(r16, r17, r18, false, r19, r20, null, null);
    }

    public static void a(Context r12, View r13, y6b.a<MediaContentVO> r14, boolean r15, b3b.j r16, mya.h r17, String r18, String r19) {
        Log.i("MediaUtil", "handleMediaClick");
        if (r16 != null) goto L8;
        if (r17 != null) goto L6;
        return;
    L6:
        if (r17.d(mya.r.class) == true) goto L8;
        return;
    L8:
        MediaContentVO r5 = r14.b();
        MediaImageSet r6 = com.ss.android.lark.parser.internal.d.a(r5);
        MessageIdentity r7 = new MessageIdentity(r14.getId(), r14.getChatId(), r5.n, r5.o);
        r7.setRiskObjectKeys(((MediaContent) r5.a).getRiskObjectKeys());
        r7.setSenderId(r14.g());
        y6b.b r8 = r14.a();
        if (r8 == null) goto L11;
        String r9 = r8.w;
    L12:
        r7.setSenderTenantId(r9);
        r6.setMessageIdentity(r7);
        List r10 = com.ss.android.lark.widget.photopicker.utils.l.b(Collections.singletonList(r6));
        if (CollectionUtils.isEmpty(r10) == false) goto L15;
        return;
    L15:
        PhotoItem r11 = (PhotoItem) ListProtector.get(r10, 0);
        r11.setThumbnail(v0.h(r13));
        ChatCoreModule.a().getAuditDependency().e(r14.getChatId(), r14.getId(), "video", "video");
        if (r14.isPreMessage() == true) goto L28;
        if (r17 == null) goto L25;
        if ((r12 instanceof Activity) == false) goto L25;
        mya.r r3 = r17.b(mya.r.class);
        if (r3 == null) goto L25;
        nya.a.a r2 = new nya.a.a();
        r2.a = null;
        r2.b = r14;
        r2.c = null;
        r2.d = r15;
        r2.e = 4;
        r2.f = r18;
        r2.g = r19;
        r3.e(Contexts.requireActivity(r12), r13, new nya.a(r2));
        return;
    L25:
        if (r16 == null) goto L39;
        r16.s(r13, null, r11, r15, false, 4, r14.J());
        return;
    L39:
        return;
    L28:
        String r4 = (String) r5.i.getValue();
        if (r4 != null) goto L32;
        r4 = BuildConfig.FLAVOR;
    L32:
        if (com.ss.android.lark.im.base.a.b().exists(com.ss.android.lark.im.base.a.b().z(r4)) == true) goto L35;
        LKUIToast.show(r12, UIHelper.getString(2131892314));
        return;
    L35:
        if (r16 == null) goto L40;
        r16.v(r13, r11, r15);
        return;
    L40:
        return;
    L11:
        r9 = null;
        goto L12
    }
}
