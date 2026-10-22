package com.obric.assistant.settings.autogui;

import android.content.Context;
import android.os.Build;
import com.bytedance.agentrobots.policy.RobotPolicyManager;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricSaepRestrictedPackageReader {
    public static final ObricSaepRestrictedPackageReader a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/settings/autogui/ObricSaepRestrictedPackageReader$Source;", "", "<init>", "(Ljava/lang/String;I)V", "DISABLED_OR_UNSUPPORTED", "QUERY_SAEP_PACKAGES", "UNAVAILABLE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Source extends Enum<Source> {
        public static final Source DISABLED_OR_UNSUPPORTED = null;
        public static final Source QUERY_SAEP_PACKAGES = null;
        public static final Source UNAVAILABLE = null;
        public static final /* synthetic */ Source[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Source> getEntries() {
            return b;
        }

        static {
            Source r0 = new Source("DISABLED_OR_UNSUPPORTED", 0);
            DISABLED_OR_UNSUPPORTED = r0;
            Source r1 = new Source("QUERY_SAEP_PACKAGES", 1);
            QUERY_SAEP_PACKAGES = r1;
            Source r3 = new Source("UNAVAILABLE", 2);
            UNAVAILABLE = r3;
            Source[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static Source[] values() {
            return (Source[]) a.clone();
        }

        public static Source valueOf(String r1) {
            return (Source) r27.a.a(Source.class, r1);
        }

        public Source(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final Set<String> a;
        public final Set<String> b;
        public final boolean c;
        public final Source d;

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
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            Set<String> r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Set<String> r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            int r5 = (r3 + r1) * 31;
            if (this.c == false) goto L13;
            int r6 = 1231;
        L15:
            return ((r5 + r6) * 31) + this.d.hashCode();
        L13:
            r6 = 1237;
            goto L15
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "Result(restrictedPackages=" + this.a + ", declaredPackages=" + this.b + ", isComplete=" + this.c + ", source=" + this.d + ')';
        }

        public a(Set<String> r2, Set<String> r3, boolean r4, Source r5) {
            Intrinsics.checkNotNullParameter(r5, "source");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.settings.autogui.ObricSaepRestrictedPackageReader$query$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/assistant/settings/autogui/ObricSaepRestrictedPackageReader$Result;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricSaepRestrictedPackageReader$query$2", f = "ObricSaepRestrictedPackageReader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a>, Object> {
        final /* synthetic */ Context $context;
        int label;

        public AnonymousClass2(Context r1, Continuation<? super AnonymousClass2> r2) {
            this.$context = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.$context, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super a> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L43;
            ResultKt.throwOnFailure(r9);
            if (Build.VERSION.SDK_INT < 31) goto L7;
            Context r10 = this.$context.getApplicationContext();
        L40:
            e = move-exception;
            throw e;
        L35:
            e = move-exception;
            FLogger.a.e("ObricSaepRestrictedPackageReader", "query failed", e);
            return new a(null, null, false, Source.UNAVAILABLE);
        L37:
            e = move-exception;
            FLogger.a.e("ObricSaepRestrictedPackageReader", "query unavailable because SDK linkage failed", e);
            return new a(null, null, false, Source.UNAVAILABLE);
        L10:
            if (e2.a.a(r10) == true) goto L13;
            FLogger.a.w("ObricSaepRestrictedPackageReader", "query unavailable because RobotsProtocol is not supported");     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            return new a(SetsKt.emptySet(), SetsKt.emptySet(), true, Source.DISABLED_OR_UNSUPPORTED);
        L13:
            RobotPolicyManager r11 = RobotPolicyManager.c(r10);     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            if (r11 == null) goto L16;
            Map r12 = r11.d();     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
        L17:
            if (r12 != null) goto L20;
            FLogger.a.w("ObricSaepRestrictedPackageReader", "querySaepPackages returned unavailable result");     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            return new a(null, null, false, Source.UNAVAILABLE);
        L20:
            ObricSaepRestrictedPackageReader r6 = ObricSaepRestrictedPackageReader.a;     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            Set r7 = ObricSaepRestrictedPackageReader.a(r12.get("restricted_packages"));     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            if (r7 != null) goto L23;
            r7 = SetsKt.emptySet();     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
        L23:
            Set r13 = ObricSaepRestrictedPackageReader.a(r12.get("saep_declared_packages"));     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            if (r13 != null) goto L26;
            r13 = SetsKt.emptySet();     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
        L26:
            a r5 = new a(r7, r13, true, Source.QUERY_SAEP_PACKAGES);     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            FLogger r14 = FLogger.a;     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            StringBuilder r3 = new StringBuilder("querySaepPackages success, restricted=");     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            Set<String> r1 = r5.a;     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            int r8 = -1;
            if (r1 == null) goto L29;
            int r2 = r1.size();     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
        L30:
            r3.append(r2);     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            r3.append(", declared=");     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            Set<String> r4 = r5.b;     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            if (r4 == null) goto L33;
            r8 = r4.size();     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
        L33:
            r3.append(r8);     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            r14.i("ObricSaepRestrictedPackageReader", r3.toString());     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            return r5;
        L29:
            r2 = -1;
            goto L30
        L16:
            r12 = null;
            goto L17
        L7:
            return new a(SetsKt.emptySet(), SetsKt.emptySet(), true, Source.DISABLED_OR_UNSUPPORTED);
        L43:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        a = new ObricSaepRestrictedPackageReader();
    }

    public ObricSaepRestrictedPackageReader() {
    }

    public static final Set a(Object r4) {
        if ((r4 instanceof Iterable) == false) goto L5;
        Iterable r5 = (Iterable) r4;
    L6:
        if (r5 == null) goto L33;
        ArrayList r0 = new ArrayList();
        Iterator r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L27;
        Object r2 = r6.next();
        if ((r2 instanceof String) == false) goto L13;
        String r3 = (String) r2;
    L14:
        if (r3 == null) goto L23;
        String r7 = StringsKt.trim(r3).toString();
        if (r7 == null) goto L23;
        if (r7.length() <= 0) goto L20;
        boolean r8 = true;
    L21:
        if (r8 == false) goto L23;
    L24:
        if (r7 == null) goto L9;
        r0.add(r7);
        goto L9
    L20:
        r8 = false;
    L23:
        r7 = null;
        goto L24
    L13:
        r3 = null;
        goto L14
    L27:
        return CollectionsKt.toSet(r0);
    L33:
        return null;
    L5:
        r5 = null;
        goto L6
    }

    public final Object query(Context r4, Continuation<? super a> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(r4, null), r5);
    }
}
