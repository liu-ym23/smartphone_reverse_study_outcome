package com.bytedance.android.live.liveinteract.videotalk.cposition;

import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.b;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import gd0.g;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import vh7.f;
import vm2.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\f\u0010\rR!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/cposition/CPositionContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/m;", "", "isCPositionOpen$delegate", "Lcom/bytedance/live/datacontext/p;", "isCPositionOpen", "()Lcom/bytedance/live/datacontext/m;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/EnlargeGuestInfo;", "enlargeGuestInfo$delegate", "getEnlargeGuestInfo", "enlargeGuestInfo", "<init>", "()V", "Companion", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CPositionContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p enlargeGuestInfo$delegate;
    private final p isCPositionOpen$delegate;

    public static final class a {
        public a() {
        }

        public final boolean c() {
            if (((Boolean) d.R6.getValue(null, d.a[405(0x195, float:5.68E-43)])).booleanValue() == true) goto L6;
            return false;
        L6:
            if (a("") == false) goto L15;
            CPositionContext r0 = getContext();
            if (r0 == null) goto L16;
            m<Boolean> r1 = r0.isCPositionOpen();
            if (r1 != null) goto L12;
            return false;
        L12:
            if (((Boolean) r1.getValue()).booleanValue() != true) goto L18;
            return true;
        L18:
            return false;
        L16:
            return false;
        L15:
            return false;
        }

        public final CPositionContext getContext() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(CPositionContext.class);
            if ((r0 instanceof CPositionContext) == true) goto L6;
            r0 = null;
        L6:
            return (CPositionContext) r0;
        }

        public final int d() {
            CPositionContext r0 = getContext();
            if (r0 == null) goto L10;
            m<EnlargeGuestInfo> r1 = r0.getEnlargeGuestInfo();
            if (r1 == null) goto L10;
            EnlargeGuestInfo r2 = (EnlargeGuestInfo) r1.getValue();
            if (r2 == null) goto L10;
            return r2.getEnlargeGuestType();
        L10:
            return EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Unkown.ordinal();
        }

        public final List<String> e() {
            CPositionContext r0 = getContext();
            if (r0 == null) goto L11;
            m<EnlargeGuestInfo> r1 = r0.getEnlargeGuestInfo();
            if (r1 == null) goto L11;
            EnlargeGuestInfo r2 = (EnlargeGuestInfo) r1.getValue();
            if (r2 == null) goto L11;
            List<String> r3 = b.a(r2);
            if (r3 == null) goto L11;
            return r3;
        L11:
            return CollectionsKt.emptyList();
        }

        public static boolean a(String r8) {
            Intrinsics.checkNotNullParameter(r8, "fromSource");
            String r2 = null;
            if (((Boolean) d.P6.getValue(null, d.a[403(0x193, float:5.65E-43)])).booleanValue() == true) goto L5;
            return false;
        L5:
            i r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getLiveMode();
            if (r0 == null) goto L8;
            LiveMode r1 = (LiveMode) r0.getValue();
        L9:
            m r3 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r3 == null) goto L12;
            IRoom r4 = (IRoom) r3.getValue();
        L14:
            if (aj0.a.d() == false) goto L17;
            return false;
        L17:
            if (r1 != LiveMode.VIDEO) goto L19;
        L20:
            if (r4 == null) goto L22;
            String r5 = r4.getAnchorAbValue("double_enlarge_enable");
        L24:
            if (Intrinsics.areEqual(r5, "1") == false) goto L26;
            return true;
        L26:
            HamletAvatarContext.a r6 = HamletAvatarContext.Companion;
            HamletAvatarContext r7 = r6.getContext();
            if (r7 == null) goto L45;
            j<g> r9 = r7.getHamletAvatarService();
            if (r9 == null) goto L45;
            g r10 = (g) r9.getValue();
            if (r10 == null) goto L45;
            if (r10.wp() != true) goto L45;
            HamletAvatarContext r11 = r6.getContext();
            if (r11 == null) goto L66;
            j<g> r12 = r11.getHamletAvatarService();
            if (r12 == null) goto L67;
            g r13 = (g) r12.getValue();
            if (r13 != null) goto L41;
            return false;
        L41:
            if (r13.I6() != true) goto L69;
            return true;
        L69:
            return false;
        L67:
            return false;
        L66:
            return false;
        L45:
            if (r1 == LiveMode.AUDIO) goto L47;
        L65:
            return false;
        L47:
            if (r4 == null) goto L49;
            String r14 = r4.getAnchorAbValue("audio_double_enlarge_enable");
        L51:
            if (Intrinsics.areEqual(r14, "1") == true) goto L56;
            if (r4 == null) goto L55;
            r2 = r4.getAnchorAbValue("audio_double_enlarge_enable");
        L55:
            if (Intrinsics.areEqual(r2, "2") == false) goto L65;
        L56:
            Integer r15 = je0.d.h();
            if (r15 != null) goto L60;
        L64:
            return true;
        L60:
            if (r15.intValue() != 30) goto L64;
            if ((!Intrinsics.areEqual(r8, "AudioTalkSettingFragment")) == false) goto L64;
            return false;
        L49:
            r14 = null;
            goto L51
        L22:
            r5 = null;
            goto L24
        L19:
            if (r1 != LiveMode.THIRD_PARTY) goto L26;
        L12:
            r4 = null;
            goto L14
        L8:
            r1 = null;
            goto L9
        }

        public static /* synthetic */ boolean b(a r0) {
            r0.getClass();
            return a("");
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(CPositionContext.class, "isCPositionOpen", "isCPositionOpen()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(CPositionContext.class, "enlargeGuestInfo", "getEnlargeGuestInfo()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    public final m<EnlargeGuestInfo> getEnlargeGuestInfo() {
        return (m) this.enlargeGuestInfo$delegate.a(this, $$delegatedProperties[1]);
    }

    public final m<Boolean> isCPositionOpen() {
        return (m) this.isCPositionOpen$delegate.a(this, $$delegatedProperties[0]);
    }

    public CPositionContext() {
        this.isCPositionOpen$delegate = q.d(this, Boolean.FALSE);
        this.enlargeGuestInfo$delegate = q.d(this, f.c(EnlargeGuestInfo.class));
    }
}
