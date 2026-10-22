package com.larus.bmhome.chat.component.bottom.multimodal.upload;

import android.net.Uri;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.upload.ResourceUploader;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import ic8.m0;
import ic8.n0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class SharedAlbumUploadCoordinator {
    public static final SharedAlbumUploadCoordinator a = null;
    public static final CoroutineScope b = null;
    public static final Object c = null;
    public static final Map<b, c> d = null;
    public static final Map<String, c> e = null;

    public static final class a {
        public final boolean a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r1 = r0 * 31;
            String r2 = this.b;
            if (r2 != null) goto L9;
            int r3 = 0;
        L11:
            return r1 + r3;
        L9:
            r3 = r2.hashCode();
            goto L11
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "CancelDecision(handled=" + this.a + ", underlyingIdentifierToCancel=" + this.b + ')';
        }

        public a(boolean r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;
        public final ns8.b d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            ns8.b r1 = this.d;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "ShareKey(uploadTaskShareTag=" + this.a + ", conversationId=" + this.b + ", uri=" + this.c + ", processConfig=" + this.d + ')';
        }

        public b(String r2, String r3, String r4, ns8.b r5) {
            Intrinsics.checkNotNullParameter(r2, "uploadTaskShareTag");
            Intrinsics.checkNotNullParameter(r3, "conversationId");
            Intrinsics.checkNotNullParameter(r4, "uri");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class c {
        public final b a;
        public final String b;
        public Job c;
        public final LinkedHashMap<String, d> d;
        public String e;
        public Boolean f;
        public n0 g;
        public Long h;
        public mr9.l i;

        public c(b r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "leaderIdentifier");
            this.a = r2;
            this.b = r3;
            this.d = new LinkedHashMap();
            this.e = r3;
        }
    }

    public static final class d {
        public final q a;
        public n0 b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            n0 r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.c;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Subscriber(param=" + this.a + ", processResult=" + this.b + ", originalRemoteDeleteFlag=" + this.c + ')';
        }

        public d(q r4) {
            Map r0 = r4.e.getExtra();
            if (r0 == null) goto L5;
            String r1 = (String) r0.get("disable_remote_delete");
        L6:
            Intrinsics.checkNotNullParameter(r4, "param");
            this.a = r4;
            this.b = null;
            this.c = r1;
            return;
        L5:
            r1 = null;
            goto L6
        }

        public final void a(boolean r3) {
            Map r0 = this.a.e.getExtra();
            if (r0 != null) goto L5;
            r0 = MapsKt.emptyMap();
        L5:
            Map r1 = MapsKt.toMutableMap(r0);
            if (r3 == false) goto L11;
            String r4 = this.c;
            if (r4 != null) goto L10;
            r1.remove("disable_remote_delete");
        L12:
            UplinkFileEntity r5 = this.a.e;
            if ((!r1.isEmpty()) == true) goto L16;
            r1 = null;
        L16:
            r5.setExtra(r1);
            return;
        L10:
            r1.put("disable_remote_delete", r4);
            goto L12
        L11:
            r1.put("disable_remote_delete", "1");
            goto L12
        }
    }

    public static final class e implements m {
        public final c a;

        public e(c r2) {
            Intrinsics.checkNotNullParameter(r2, "task");
            this.a = r2;
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.m
        public final void c(boolean r6) {
            Object r0 = SharedAlbumUploadCoordinator.c;
            monitor-enter(r0);
            this.a.f = Boolean.valueOf(r6);     // Catch: Throwable -> L13
            List r1 = CollectionsKt.toList(this.a.d.values());     // Catch: Throwable -> L13
            monitor-exit(r0);
            FLogger.a.i("SharedAlbumUpload", "shared upload intercept result, leader=" + this.a.b + ", intercept=" + r6 + ", subscribers=" + r1.size());
            Iterator r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L10;
            ((d) r2.next()).a.c.c(r6);
            goto L8
        L10:
            if (r6 == false) goto L19;
            SharedAlbumUploadCoordinator r7 = SharedAlbumUploadCoordinator.a;
            SharedAlbumUploadCoordinator.a(this.a);
            return;
        L19:
            return;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.m
        public final void d(n0 r8) {
            Intrinsics.checkNotNullParameter(r8, "processResult");
            Object r0 = SharedAlbumUploadCoordinator.c;
            monitor-enter(r0);
            c r1 = this.a;     // Catch: Throwable -> L33
            r1.g = r8;     // Catch: Throwable -> L33
            Collection<d> r2 = r1.d.values();     // Catch: Throwable -> L33
            ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));     // Catch: Throwable -> L33
            Iterator<T> r4 = r2.iterator();     // Catch: Throwable -> L33
        L6:
            if (r4.hasNext() == false) goto L9;
            d r5 = (d) r4.next();     // Catch: Throwable -> L33
            SharedAlbumUploadCoordinator r6 = SharedAlbumUploadCoordinator.a;     // Catch: Throwable -> L33
            n0 r7 = SharedAlbumUploadCoordinator.e(r8);     // Catch: Throwable -> L33
            r5.b = r7;     // Catch: Throwable -> L33
            r3.add(TuplesKt.to(r5, r7));     // Catch: Throwable -> L33
            goto L6
        L9:
            monitor-exit(r0);
            FLogger r9 = FLogger.a;
            StringBuilder r10 = new StringBuilder("shared upload preprocess result, leader=");
            r10.append(this.a.b);
            r10.append(", success=");
            ProcessFileResultCode r11 = r8.b;
            boolean r12 = false;
            if (r11 != null) goto L13;
        L15:
            boolean r13 = false;
        L16:
            r10.append(r13);
            r10.append(", subscribers=");
            r10.append(r3.size());
            r9.i("SharedAlbumUpload", r10.toString());
            Iterator r14 = r3.iterator();
        L18:
            if (r14.hasNext() == false) goto L20;
            Pair r15 = (Pair) r14.next();
            d r16 = (d) r15.component1();
            n0 r17 = (n0) r15.component2();
            SharedAlbumUploadCoordinator r18 = SharedAlbumUploadCoordinator.a;
            SharedAlbumUploadCoordinator.f(this.a, r16);
            r16.a.c.d(r17);
            goto L18
        L20:
            ProcessFileResultCode r19 = r8.b;
            if (r19 != null) goto L23;
        L25:
            if (r12 == false) goto L31;
            m0 r20 = r8.a;
            if (r20 == null) goto L29;
            String r21 = r20.e;
        L30:
            if (r21 == null) goto L31;
            return;
        L29:
            r21 = null;
        L31:
            SharedAlbumUploadCoordinator r22 = SharedAlbumUploadCoordinator.a;
            SharedAlbumUploadCoordinator.a(this.a);
            return;
        L23:
            if (r19.isSuccess() != true) goto L25;
            r12 = true;
            goto L25
        L13:
            if (r11.isSuccess() != true) goto L15;
            r13 = true;
        L33:
            th = move-exception;
            throw th;
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.n
        public final void a(long r3, String r5) {
            Intrinsics.checkNotNullParameter(r5, "fileIdentifier");
            Object r6 = SharedAlbumUploadCoordinator.c;
            monitor-enter(r6);
            c r0 = this.a;     // Catch: Throwable -> L14
            r0.h = Long.valueOf(r3);     // Catch: Throwable -> L14
            List r1 = CollectionsKt.toList(this.a.d.values());     // Catch: Throwable -> L14
            monitor-exit(r6);
            Iterator r7 = r1.iterator();
        L8:
            if (r7.hasNext() == false) goto L13;
            q r2 = ((d) r7.next()).a;
            m r4 = r2.c;
            String r8 = r2.e.getFileIdentifier();
            if (r8 != null) goto L12;
            r8 = "";
        L12:
            r4.a(r3, r8);
            goto L8
        L13:
            return;
        L14:
            th = move-exception;
            throw th;
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.n
        public final void b(mr9.l r5, String r6) {
            Intrinsics.checkNotNullParameter(r5, "uploadResult");
            Intrinsics.checkNotNullParameter(r6, "fileIdentifier");
            Object r7 = SharedAlbumUploadCoordinator.c;
            monitor-enter(r7);
            c r0 = this.a;     // Catch: Throwable -> L11
            r0.i = r5;     // Catch: Throwable -> L11
            List r1 = CollectionsKt.toList(r0.d.values());     // Catch: Throwable -> L11
            monitor-exit(r7);
            FLogger.a.i("SharedAlbumUpload", "shared upload success, leader=" + this.a.b + ", resourceId=" + r5.c + ", subscribers=" + r1.size());
            Iterator r8 = r1.iterator();
        L8:
            if (r8.hasNext() == false) goto L10;
            d r2 = (d) r8.next();
            SharedAlbumUploadCoordinator r3 = SharedAlbumUploadCoordinator.a;
            c r4 = this.a;
            Intrinsics.checkNotNull(r2);
            SharedAlbumUploadCoordinator.d(r4, r2, r5);
            goto L8
        L10:
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.n
        public final void e(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
            SharedAlbumUploadCoordinator r5 = SharedAlbumUploadCoordinator.a;
            SharedAlbumUploadCoordinator.b(this.a, r2, r4);
        }
    }

    public static final class f extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public final /* synthetic */ String a;
        public final /* synthetic */ c b;

        public final void handleException(CoroutineContext r3, Throwable r4) {
            if ((r4 instanceof CancellationException) == true) goto L6;
            FLogger.a.e("SharedAlbumUpload", "shared upload failed before callback, identifier=" + this.a, r4);
            SharedAlbumUploadCoordinator r5 = SharedAlbumUploadCoordinator.a;
            SharedAlbumUploadCoordinator.b(this.b, r4.getMessage(), null);
            return;
        }

        public f(CoroutineExceptionHandler.Key r1, String r2, c r3) {
            this.a = r2;
            this.b = r3;
            super(r1);
        }
    }

    public SharedAlbumUploadCoordinator() {
    }

    static {
        a = new SharedAlbumUploadCoordinator();
        b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        c = new Object();
        d = new LinkedHashMap();
        e = new LinkedHashMap();
    }

    public static final void a(c r1) {
        Object r0 = c;
        monitor-enter(r0);
        h(r1);     // Catch: Throwable -> L7
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static a c(String r9) {
        Intrinsics.checkNotNullParameter(r9, "fileIdentifier");
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        Object r1 = c;
        monitor-enter(r1);
        c r2 = e.remove(r9);     // Catch: Throwable -> L42
        int r5 = 0;
        if (r2 != null) goto L7;
        a r3 = new a(false, null);     // Catch: Throwable -> L42
    L31:
        monitor-exit(r1);
        Job r4 = (Job) r0.element;
        if (r4 == null) goto L36;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L36:
        if (r3.a == true) goto L38;
        return r3;
    L38:
        if (r5 <= 0) goto L40;
        FLogger.a.i("SharedAlbumUpload", "remove subscriber, keep shared upload, identifier=" + r9 + ", remaining=" + r5);
    L41:
        return r3;
    L40:
        FLogger.a.i("SharedAlbumUpload", "remove last subscriber, identifier=" + r9);
        goto L41
    L7:
        d r6 = r2.d.remove(r9);     // Catch: Throwable -> L42
        int r7 = r2.d.size();     // Catch: Throwable -> L42
        if ((!r2.d.isEmpty()) == true) goto L10;
        g(r2);     // Catch: Throwable -> L42
        Job r8 = r2.c;     // Catch: Throwable -> L42
        if (r8 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("submissionJob");     // Catch: Throwable -> L42
        r8 = null;
    L20:
        if (Boolean.valueOf(r8.isCompleted()).booleanValue() == false) goto L23;
        r8 = null;
    L23:
        r0.element = r8;     // Catch: Throwable -> L42
        String r10 = r2.b;     // Catch: Throwable -> L42
        if (r2.i != null) goto L26;
        r5 = 1;
    L26:
        if (r5 != 0) goto L29;
        r10 = null;
    L29:
        r3 = new a(true, r10);     // Catch: Throwable -> L42
    L30:
        r5 = r7;
        goto L31
    L10:
        if (Intrinsics.areEqual(r2.e, r9) == false) goto L14;
        if (r6 == null) goto L13;
        r6.a(false);     // Catch: Throwable -> L42
    L13:
        Map.Entry r11 = (Map.Entry) CollectionsKt.first(r2.d.entrySet());     // Catch: Throwable -> L42
        String r12 = (String) r11.getKey();     // Catch: Throwable -> L42
        d r13 = (d) r11.getValue();     // Catch: Throwable -> L42
        Intrinsics.checkNotNullParameter(r12, "<set-?>");     // Catch: Throwable -> L42
        r2.e = r12;     // Catch: Throwable -> L42
        r13.a(true);     // Catch: Throwable -> L42
    L14:
        r3 = new a(true, null);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        throw th;
    }

    public static n0 e(n0 r3) {
        m0 r0 = r3.a;
        m0 r1 = null;
        if (r0 == null) goto L6;
        r1 = m0.a(r0, null, null, null, 16383);
    L6:
        return new n0(r1, r3.b);
    }

    public static void g(c r3) {
        Map<b, c> r0 = d;
        LinkedHashMap r2 = (LinkedHashMap) r0;
        if (r2.get(r3.a) != r3) goto L6;
        r0.remove(r3.a);
        return;
    }

    public static void h(c r5) {
        g(r5);
        Iterator<Map.Entry<String, d>> r0 = r5.d.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Map.Entry<String, d> r1 = r0.next();
        String r2 = r1.getKey();
        d r3 = r1.getValue();
        Map<String, c> r4 = e;
        if (((LinkedHashMap) r4).get(r2) != r5) goto L8;
        r4.remove(r2);
    L8:
        r3.a(true);
        goto L4
    L9:
        r5.d.clear();
    }

    public static void f(c r1, d r2) {
        if (n1.e(r2.a.e) == true) goto L5;
        return;
    L5:
        String r3 = r2.a.e.getFileIdentifier();
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        if (Intrinsics.areEqual(r3, r1.b) == false) goto L11;
        return;
    L11:
        mr9.e r4 = com.larus.bmhome.upload.h.a.query(r1.b);
        if (r4 == null) goto L15;
        com.larus.bmhome.upload.h.a(r3, r4, "SharedAlbumUpload");
        return;
    }

    public static final void b(c r5, String r6, String r7) {
        Object r0 = c;
        monitor-enter(r0);
        List r1 = CollectionsKt.toList(r5.d.values());     // Catch: Throwable -> L14
        h(r5);     // Catch: Throwable -> L14
        monitor-exit(r0);
        FLogger.a.e("SharedAlbumUpload", "shared upload failed, leader=" + r5.b + ", code=" + r7 + ", subscribers=" + r1.size() + ", message=" + r6);
        Iterator r8 = r1.iterator();
    L8:
        if (r8.hasNext() == false) goto L13;
        d r2 = (d) r8.next();
        String r3 = r2.a.e.getFileIdentifier();
        if (r3 != null) goto L12;
        r3 = "";
    L12:
        r2.a.c.e(r6, r3, r7);
        goto L8
    L13:
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public static void d(c r5, d r6, mr9.l r7) {
        String r8 = r6.a.e.getFileIdentifier();
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        Object r0 = c;
        monitor-enter(r0);
        Map<String, c> r1 = e;     // Catch: Throwable -> L40
        if (((LinkedHashMap) r1).get(r8) != r5) goto L10;
        r1.remove(r8);     // Catch: Throwable -> L40
    L10:
        d r2 = r5.d.remove(r8);     // Catch: Throwable -> L40
        d r3 = r2;     // Catch: Throwable -> L40
        if (r5.d.isEmpty() == false) goto L13;
        g(r5);     // Catch: Throwable -> L40
    L13:
        d r4 = r2;     // Catch: Throwable -> L40
        monitor-exit(r0);
        if (r4 != null) goto L17;
        return;
    L17:
        String r9 = r7.c;
        if (r9 == null) goto L38;
        boolean r10 = false;
        if (r9.length() <= 0) goto L22;
        boolean r11 = true;
    L23:
        if (r11 == true) goto L26;
        r9 = null;
    L26:
        if (r9 == null) goto L38;
        ResourceCenter.a.getClass();
        Intrinsics.checkNotNullParameter(r8, "identifier");
        Intrinsics.checkNotNullParameter(r9, "resourceId");
        if (r8.length() != 0) goto L30;
        boolean r12 = true;
    L31:
        if (r12 == true) goto L38;
        if (r9.length() != 0) goto L35;
        r10 = true;
    L35:
        if (r10 == true) goto L38;
        ResourceCenter.e.put(r8, r9);
        goto L38
    L30:
        r12 = false;
        goto L31
    L22:
        r11 = false;
    L38:
        FLogger.a.i("SharedAlbumUpload", "dispatch shared upload result, identifier=" + r8 + ", resourceId=" + r7.c + ", resourceOwner=" + Intrinsics.areEqual(r8, r5.e));
        r4.a.c.b(r7, r8);
        return;
    L40:
        th = move-exception;
        throw th;
    }

    public final Object i(q r22, ns8.b r23, Function3<? super q, ? super ns8.b, ? super Continuation<? super Unit>, ? extends Object> r24, Function0<Unit> r25, Continuation<? super Boolean> r26) {
        if ((r26 instanceof SharedAlbumUploadCoordinator$submit$1) == false) goto L7;
        SharedAlbumUploadCoordinator$submit$1 r2 = (SharedAlbumUploadCoordinator$submit$1) r26;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        SharedAlbumUploadCoordinator$submit$1 r8 = r2;
        Object r1 = r8.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r8.label;
        if (r4 == 0) goto L18;
        if (r4 != 1) goto L17;
        String r5 = (String) r8.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L14
    L139:
        if (JobKt.isActive(r8.getContext()) == true) goto L144;
        String r0 = c(r5).b;
        if (r0 == null) goto L144;
        ResourceUploader r6 = ResourceUploader.a;
        ResourceUploader.b(r0, ResourceUploader.a.a.a);
    L144:
        return Boxing.boxBoolean(true);
    L14:
        th = th;
    L148:
        if (JobKt.isActive(r8.getContext()) == true) goto L152;
        String r7 = c(r5).b;
        if (r7 == null) goto L152;
        ResourceUploader r10 = ResourceUploader.a;
        ResourceUploader.b(r7, ResourceUploader.a.a.a);
    L152:
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r1);
        String r11 = r22.j;
        if (Intrinsics.areEqual(r11, "photo_picker_attachment") == true) goto L22;
    L57:
        b r13 = null;
    L59:
        if (r13 == null) goto L61;
        String r12 = r22.e.getFileIdentifier();
        if (r12 != null) goto L65;
    L72:
        r12 = UUID.randomUUID().toString();
        r22.e.setFileIdentifier(r12);
    L73:
        final String r14 = r12;
        if (r25 == null) goto L76;
        r25.invoke();
    L76:
        Ref.ObjectRef r15 = new Ref.ObjectRef();
        Ref.ObjectRef r16 = new Ref.ObjectRef();
        d r17 = new d(r22);
        Object r18 = c;
        monitor-enter(r18);
        Map<b, c> r19 = d;     // Catch: Throwable -> L153
        c r20 = (c) ((LinkedHashMap) r19).get(r13);     // Catch: Throwable -> L153
        if (r20 != null) goto L82;
        c r21 = new c(r13, r14);     // Catch: Throwable -> L153
        Job r27 = BuildersKt.launch(b, new f(CoroutineExceptionHandler.Key, r14, r21), CoroutineStart.LAZY, new SharedAlbumUploadCoordinator$submit$replay$1$task$1$1(r24, r22, r21, r23, null));     // Catch: Throwable -> L153
        r27.invokeOnCompletion(new p(r14));     // Catch: Throwable -> L153
        Intrinsics.checkNotNullParameter(r27, "<set-?>");     // Catch: Throwable -> L153
        r21.c = r27;     // Catch: Throwable -> L153
        r19.put(r13, r21);     // Catch: Throwable -> L153
        r15.element = r21;     // Catch: Throwable -> L153
        r20 = r21;
    L82:
        r16.element = r20;     // Catch: Throwable -> L153
        r17.a(r20.d.isEmpty());     // Catch: Throwable -> L153
        r20.d.put(r14, r17);     // Catch: Throwable -> L153
        e.put(r14, r20);     // Catch: Throwable -> L153
        Boolean r28 = r20.f;     // Catch: Throwable -> L153
        n0 r29 = r20.g;     // Catch: Throwable -> L153
        Long r30 = r20.h;     // Catch: Throwable -> L153
        mr9.l r31 = r20.i;     // Catch: Throwable -> L153
        int r32 = r20.d.size();     // Catch: Throwable -> L153
        monitor-exit(r18);
        m r110 = r22.c;
        if ((r110 instanceof com.larus.bmhome.chat.component.bottom.multimodal.upload.a) == false) goto L87;
        com.larus.bmhome.chat.component.bottom.multimodal.upload.a r111 = (com.larus.bmhome.chat.component.bottom.multimodal.upload.a) r110;
    L88:
        if (r111 != null) goto L90;
    L94:
        if (r28 == null) goto L96;
        r110.c(r28.booleanValue());
    L96:
        if (r29 == null) goto L102;
        n0 r33 = e(r29);
        Object r112 = r16.element;
        if (r112 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("joinedTask");
        c r113 = null;
    L101:
        f(r113, r17);
        r17.b = r33;
        r22.c.d(r33);
        goto L102
    L100:
        r113 = (c) r112;
    L102:
        if (r30 == null) goto L104;
        r22.c.a(r30.longValue(), r14);
    L104:
        if (r31 == null) goto L110;
        Object r34 = r16.element;
        if (r34 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("joinedTask");
        c r35 = null;
    L109:
        d(r35, r17, r31);
        goto L110
    L108:
        r35 = (c) r34;
    L110:
        c r36 = (c) r15.element;
        if (r36 != null) goto L121;
        FLogger r37 = FLogger.a;
        StringBuilder r38 = new StringBuilder("join shared upload, identifier=");
        r38.append(r14);
        r38.append(", subscribers=");
        r38.append(r32);
        r38.append(", replayPreprocess=");
        if (r29 == null) goto L115;
        boolean r39 = true;
    L116:
        r38.append(r39);
        r38.append(", replayUpload=");
        if (r31 == null) goto L119;
        boolean r114 = true;
    L120:
        r38.append(r114);
        r37.i("SharedAlbumUpload", r38.toString());
    L160:
        Object r40 = r16.element;     // Catch: Throwable -> L145
        if (r40 != null) goto L129;
        Intrinsics.throwUninitializedPropertyAccessException("joinedTask");     // Catch: Throwable -> L145
        c r41 = null;
    L130:
        Job r42 = r41.c;     // Catch: Throwable -> L145
        if (r42 == null) goto L133;
        Job r115 = r42;
    L134:
        r8.L$0 = r14;     // Catch: Throwable -> L145
        r8.label = 1;     // Catch: Throwable -> L145
        if (r115.join(r8) != r9) goto L137;
        return r9;
    L137:
        r5 = r14;
        goto L139
    L133:
        Intrinsics.throwUninitializedPropertyAccessException("submissionJob");     // Catch: Throwable -> L145
        r115 = null;
        goto L134
    L129:
        r41 = (c) r40;     // Catch: Throwable -> L145
    L145:
        th = th;
        r5 = r14;
        goto L148
    L119:
        r114 = false;
        goto L120
    L115:
        r39 = false;
        goto L116
    L121:
        FLogger.a.i("SharedAlbumUpload", "start shared upload, identifier=" + r14 + ", subscribers=" + r32);
        Job r43 = r36.c;
        if (r43 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("submissionJob");
        r43 = null;
    L125:
        Boxing.boxBoolean(r43.start());
        goto L160
    L90:
        if (r15.element == null) goto L92;
        boolean r116 = true;
    L93:
        r111.x = r116;
        goto L94
    L92:
        r116 = false;
        goto L93
    L87:
        r111 = null;
    L153:
        th = move-exception;
        throw th;
    L65:
        if (r12.length() <= 0) goto L67;
        boolean r44 = true;
    L68:
        if (r44 == true) goto L71;
        r12 = null;
    L71:
        if (r12 != null) goto L73;
    L67:
        r44 = false;
        goto L68
    L61:
        return Boxing.boxBoolean(false);
    L22:
        if (z2.a.fastAlbumSingleUploadAttachmentSyncEnable() == true) goto L25;
        String r45 = "setting_disabled";
    L55:
        if (r45 == null) goto L58;
        FLogger.a.i("SharedAlbumUpload", "skip shared upload, identifier=" + r22.e.getFileIdentifier() + ", reason=" + r45);
        goto L57
    L58:
        r13 = new b(r11, r22.a, String.valueOf(r22.e.getUri()), r23);
        goto L59
    L25:
        if (r22.b == true) goto L28;
        r45 = "not_multi_file";
        goto L55
    L28:
        if (r22.f == false) goto L31;
        r45 = "skipped_attachment";
        goto L55
    L31:
        if (n1.d(r22.e) == false) goto L33;
    L35:
        if (r23 != null) goto L37;
    L39:
        boolean r46 = false;
    L40:
        if (r46 == false) goto L42;
        r45 = "process_skip_upload";
        goto L55
    L42:
        Uri r47 = r22.e.getUri();
        if (r47 == null) goto L45;
        String r48 = r47.toString();
    L46:
        if (r48 != null) goto L48;
    L51:
        boolean r49 = true;
    L52:
        if (r49 == false) goto L54;
        r45 = "empty_uri";
        goto L55
    L54:
        r45 = null;
        goto L55
    L48:
        if (r48.length() == 0) goto L51;
        r49 = false;
        goto L52
    L45:
        r48 = null;
        goto L46
    L37:
        if (r23.c != true) goto L39;
        r46 = true;
        goto L40
    L33:
        if (n1.e(r22.e) == true) goto L35;
        r45 = "unsupported_media_type";
    L7:
        r2 = new SharedAlbumUploadCoordinator$submit$1(this, r26);
        goto L8
    }
}
