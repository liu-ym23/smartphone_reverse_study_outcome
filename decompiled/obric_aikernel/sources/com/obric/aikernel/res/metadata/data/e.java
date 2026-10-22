package com.obric.aikernel.res.metadata.data;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.i;
import com.google.gson.k;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.metadata.NativeLibVersionPolicy;
import com.obric.aikernel.res.metadata.config.DistConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public class e extends b {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f5097o = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f5098m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile String f5099n;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final boolean a(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            Intrinsics.checkNotNullParameter(r11, TypedValues.AttributesType.S_TARGET);
            List r12 = StringsKt.split$default(r10, new String[]{"."}, false, 0, 6, null);
            ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
            Iterator r14 = r12.iterator();
        L4:
            if (r14.hasNext() == false) goto L6;
            r13.add(StringsKt.toIntOrNull((String) r14.next()));
            goto L4
        L6:
            List r15 = StringsKt.split$default(r11, new String[]{"."}, false, 0, 6, null);
            ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
            Iterator r17 = r15.iterator();
        L8:
            if (r17.hasNext() == false) goto L10;
            r16.add(StringsKt.toIntOrNull((String) r17.next()));
            goto L8
        L10:
            Iterator r18 = r13.iterator();
            int r19 = 0;
        L12:
            if (r18.hasNext() == false) goto L30;
            Object r20 = r18.next();
            int r21 = r19 + 1;
            if (r19 >= 0) goto L16;
            CollectionsKt.throwIndexOverflow();
        L16:
            Integer r22 = (Integer) r20;
            if (r22 == null) goto L19;
            int r23 = r22.intValue();
        L20:
            Integer r24 = (Integer) CollectionsKt.getOrNull(r16, r19);
            if (r24 == null) goto L23;
            int r25 = r24.intValue();
        L24:
            if (r23 > r25) goto L25;
            if (r23 < r25) goto L28;
            r19 = r21;
            goto L12
        L28:
            return false;
        L25:
            return true;
        L23:
            r25 = 0;
            goto L24
        L19:
            r23 = 0;
            goto L20
        L30:
            return false;
        }
    }

    static {
        f5097o = new a(null);
    }

    public e(String r10, String r11, PackageResourceManager.PresmConfig r12) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "version");
        Intrinsics.checkNotNullParameter(r12, "config");
        super(r10, r11, r12);
        this.f5098m = StringsKt.startsWith$default(r10, "native_", false, 2, null);
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public String A() {
        return "lib";
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public String B() {
        return "libs";
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    protected void T() {
        super.T();
        u();
        if (this.f5098m == false) goto L6;
        NativeLibVersionPolicy.INSTANCE.onNativeLibInstalled$resource_manager_release(this);
        return;
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public boolean Z() {
        if (super.Z() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.f5098m == true) goto L7;
    L8:
        return true;
    L7:
        if (g0() == false) goto L9;
        goto L8
    }

    public final boolean g0() {
        String r10 = NativeLibVersionPolicy.INSTANCE.getVersion(w());
        boolean r11 = false;
        if (r10 == null) goto L8;
        if ((!f5097o.a(D(), r10)) == true) goto L8;
        r11 = true;
    L8:
        return !r11;
    }

    public final boolean h0() {
        return this.f5098m;
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public String u() {
        if (this.f5099n != null) goto L33;
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L6:
        if (this.f5099n != null) goto L27;
        DistConfig r10 = s();     // Catch: Throwable -> L30
        String r11 = null;
        if (r10 == null) goto L10;
        k r12 = r10.f();     // Catch: Throwable -> L30
    L11:
        if (r12 == null) goto L26;
        i r13 = r12.s(WsConstants.KEY_EXTRA);     // Catch: Throwable -> L30
        boolean r14 = true;
        if (r13 != null) goto L15;
    L17:
        r14 = false;
    L19:
        if (Boolean.valueOf(r14).booleanValue() == true) goto L22;
        r12 = null;
    L22:
        if (r12 == null) goto L26;
        i r15 = r12.s(WsConstants.KEY_EXTRA);     // Catch: Throwable -> L30
        if (r15 == null) goto L26;
        r11 = r15.h();     // Catch: Throwable -> L30
        goto L26
    L15:
        if (r13.l() != true) goto L17;
    L26:
        this.f5099n = r11;     // Catch: Throwable -> L30
        goto L27
    L10:
        r12 = null;
    L27:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L30
        monitor-exit(this);
    L33:
        String r17 = this.f5099n;
        if (r17 != null) goto L39;
        return "{}";
    L39:
        return r17;
    }
}
