package com.bytedance.android.live.liveinteract.videotalk.quickinteract;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.message.model.n7;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface b {
    public static final C0101b r0 = null;

    public interface a {
        void a(n7 r1);

        int b(QuickInteractTask r1);

        void c(QuickInteractTask r1);
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.videotalk.quickinteract.b$b, reason: collision with other inner class name */
    public static final class C0101b {
        public static final /* synthetic */ C0101b a = null;

        public C0101b() {
        }

        static {
            a = new C0101b();
        }

        @JvmStatic
        public static b a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d("quick_interact_service");
            if ((r0 instanceof QuickInteractContext) == true) goto L5;
            r0 = null;
        L5:
            QuickInteractContext r1 = (QuickInteractContext) r0;
            if (r1 == null) goto L11;
            j<b> r2 = r1.getService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (b) r2.getValue();
        L11:
            return null;
        }

        @JvmStatic
        public static boolean b() {
            o r0 = m.l(null, 0L);
            if (r0 == null) goto L5;
            Boolean r1 = r0.isAnchor();
        L7:
            if (Intrinsics.areEqual(r1, Boolean.TRUE) == true) goto L9;
            ReadOnlyProperty r2 = vm2.d.h4;
            KProperty[] r3 = vm2.d.a;
            if (((Boolean) r2.getValue(null, r3[265(0x109, float:3.71E-43)])).booleanValue() == true) goto L13;
        L15:
            return false;
        L13:
            if (((Boolean) vm2.d.q6.getValue(null, r3[378(0x17a, float:5.3E-43)])).booleanValue() == false) goto L15;
            return true;
        L9:
            return ((Boolean) vm2.d.h4.getValue(null, vm2.d.a[265(0x109, float:3.71E-43)])).booleanValue();
        L5:
            r1 = null;
            goto L7
        }

        @JvmStatic
        public static boolean c(ILinkPlayerInfoBridge r1) {
            if (r1 == null) goto L6;
            IBaseUser r2 = r1.getUser();
            if (r2 == null) goto L6;
            String r3 = r2.getIdString();
        L8:
            if (Intrinsics.areEqual(r3, je0.d.b0()) == true) goto L10;
        L12:
            return false;
        L10:
            if (b() == false) goto L12;
            return true;
        L6:
            r3 = null;
            goto L8
        }
    }

    public static final class c {
        public static /* synthetic */ void a(b r1, QuickInteractTask r2, String r3) {
            r1.vk(r2, r3, IQuickInteractService$sendThanksInteract$1.INSTANCE);
        }
    }

    static {
        r0 = C0101b.a;
    }

    void C9(BaseMultiLinkWindowManager.c r1);

    void F6();

    void Fn(String r1);

    void Si(QuickInteractTask r1, boolean r2);

    void Xb(QuickInteractTask r1);

    void aj(String r1, long r2, String r4, Function1<? super Integer, Unit> r5);

    boolean isEmpty();

    void k7(QuickInteractTask r1);

    void vk(QuickInteractTask r1, String r2, Function1<? super Integer, Unit> r3);
}
