package com.obric.assistant.interaction.impl.window;

import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.os.IBinder;
import android.view.ViewParent;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import el9.a;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/ChatWindowReflectionCompat;", "", "<init>", "()V", "ViewRootImplRef", "ActivityThreadRef", "LoadedApkRef", "ContextImplRef", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatWindowReflectionCompat {
    public static final ChatWindowReflectionCompat INSTANCE = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001¨\u0006\b"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/ChatWindowReflectionCompat$ActivityThreadRef;", "", "<init>", "()V", "current", "instrumentation", "Landroid/app/Instrumentation;", "at", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ActivityThreadRef {
        public static final ActivityThreadRef INSTANCE = null;

        static {
            INSTANCE = new ActivityThreadRef();
        }

        private ActivityThreadRef() {
        }

        public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
            return Class.forName(r0);
        }

        public final Object current() {
            Method r1 = INVOKESTATIC_com_obric_assistant_interaction_impl_window_ChatWindowReflectionCompat$ActivityThreadRef_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread").getDeclaredMethod("currentActivityThread", new Class[0]);     // Catch: Throwable -> L5
            r1.setAccessible(true);     // Catch: Throwable -> L5
            return r1.invoke(null, new Object[0]);
        L8:
            return null;
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_obric_assistant_interaction_impl_window_ChatWindowReflectionCompat$ActivityThreadRef_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
            ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
            FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (a.a() == true) goto L34;
            Class r2 = access$000(r3);     // Catch: Throwable -> L8
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
        L7:
            return r2;
        L8:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r3);
        L12:
            throw th;
        L34:
            Class r4 = access$000(r3);     // Catch: Throwable -> L17
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
        L16:
            return r4;
        L17:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r3);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r3);
        }

        public final Instrumentation instrumentation(Object r4) {
            if (r4 == null) goto L14;
            Field r1 = r4.getClass().getDeclaredField("mInstrumentation");     // Catch: Throwable -> L10
            r1.setAccessible(true);     // Catch: Throwable -> L10
            Object r5 = r1.get(r4);     // Catch: Throwable -> L10
            if ((r5 instanceof Instrumentation) == false) goto L13;
            return (Instrumentation) r5;
        L13:
            return null;
        L15:
            return null;
        L14:
            return null;
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000bJ\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u001f\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/ChatWindowReflectionCompat$ContextImplRef;", "", "<init>", "()V", "cls", "Ljava/lang/Class;", "getCls", "()Ljava/lang/Class;", "cls$delegate", "Lkotlin/Lazy;", "createActivityContext", "Landroid/content/Context;", "at", "loadedApk", "activityInfo", "Landroid/content/pm/ActivityInfo;", "token", "Landroid/os/IBinder;", "displayId", "", "overrideConfig", "Landroid/content/res/Configuration;", "setOuterContext", "", "contextImpl", "outer", "findField", "Ljava/lang/reflect/Field;", "c", "name", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ContextImplRef {
        public static final ContextImplRef INSTANCE = null;
        private static final Lazy cls$delegate = null;

        private ContextImplRef() {
        }

        public static /* synthetic */ Method a(Class[] r0) {
            return createActivityContext$lambda$3(r0);
        }

        public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
            return Class.forName(r0);
        }

        public static /* synthetic */ Class b() {
            return cls_delegate$lambda$0();
        }

        static {
            INSTANCE = new ContextImplRef();
            cls$delegate = LazyKt.lazy(new m());
        }

        private static final Class cls_delegate$lambda$0() {
            return INVOKESTATIC_com_obric_assistant_interaction_impl_window_ChatWindowReflectionCompat$ContextImplRef_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ContextImpl");
        }

        private final Class<?> getCls() {
            return (Class) cls$delegate.getValue();
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_obric_assistant_interaction_impl_window_ChatWindowReflectionCompat$ContextImplRef_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
            ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
            FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (a.a() == true) goto L34;
            Class r2 = access$000(r3);     // Catch: Throwable -> L8
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
        L7:
            return r2;
        L8:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r3);
        L12:
            throw th;
        L34:
            Class r4 = access$000(r3);     // Catch: Throwable -> L17
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
        L16:
            return r4;
        L17:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r3);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r3);
        }

        private static final Method createActivityContext$lambda$3(Class[] r3) {
            Intrinsics.checkNotNullParameter(r3, "signature");
            ContextImplRef r0 = INSTANCE;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
            Method r4 = r0.getCls().getDeclaredMethod("createActivityContext", (Class[]) Arrays.copyOf(r3, r3.length));     // Catch: Throwable -> L5
            r4.setAccessible(true);     // Catch: Throwable -> L5
            Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L5
        L8:
            if (Result.isFailure-impl(r5) == false) goto L11;
            r5 = null;
        L11:
            return (Method) r5;
        L5:
            th = move-exception;
            Result.Companion r2 = Result.Companion;
            r5 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L8
        }

        private final Field findField(Class<?> r3, String r4) {
        L2:
            if (r3 == null) goto L6;
            Field r0 = r3.getDeclaredField(r4);     // Catch: NoSuchFieldException -> L5
            r0.setAccessible(true);     // Catch: NoSuchFieldException -> L5
            return r0;
        L5:
            r3 = r3.getSuperclass();
            goto L2
        L6:
            return null;
        }

        public final void setOuterContext(Context r7, Context r8) {
            Intrinsics.checkNotNullParameter(r7, "contextImpl");
            Intrinsics.checkNotNullParameter(r8, "outer");
            Method r0 = getCls().getDeclaredMethod("setOuterContext", new Class[]{Context.class});     // Catch: Throwable -> L5
            r0.setAccessible(true);     // Catch: Throwable -> L5
            r0.invoke(r7, new Object[]{r8});     // Catch: Throwable -> L5
            return;
        L5:
            Field r1 = findField(getCls(), "mOuterContext");     // Catch: Throwable -> L9
            if (r1 == null) goto L14;
            r1.set(r7, r8);     // Catch: Throwable -> L9
            Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L9
            return;
        L14:
            return;
        L9:
            Unit r10 = Unit.INSTANCE;
        }

        public final Context createActivityContext(Object r16, Object r17, ActivityInfo r18, IBinder r19, int r20, Configuration r21) {
            Intrinsics.checkNotNullParameter(r18, "activityInfo");
            Intrinsics.checkNotNullParameter(r19, "token");
            if (r16 == null) goto L28;
            if (r17 == null) goto L31;
            Method r3 = (Method) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(CollectionsKt.listOf(new Class[][]{new Class[]{INVOKESTATIC_com_obric_assistant_interaction_impl_window_ChatWindowReflectionCompat$ContextImplRef_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread"), INVOKESTATIC_com_obric_assistant_interaction_impl_window_ChatWindowReflectionCompat$ContextImplRef_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.LoadedApk"), ActivityInfo.class, IBinder.class, Integer.TYPE, Configuration.class}, new Class[]{INVOKESTATIC_com_obric_assistant_interaction_impl_window_ChatWindowReflectionCompat$ContextImplRef_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread"), INVOKESTATIC_com_obric_assistant_interaction_impl_window_ChatWindowReflectionCompat$ContextImplRef_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.LoadedApk"), ActivityInfo.class, IBinder.class}})), new n()));
            if (r3 != null) goto L27;
        L12:
            Integer r5 = null;
        L14:
            if (r5 != null) goto L17;
        L19:
            if (r5 != null) goto L22;
            return null;
        L22:
            if (r5.intValue() != 4) goto L30;
            Object r0 = r3.invoke(null, new Object[]{r16, r17, r18, r19});     // Catch: Throwable -> L26
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.content.Context");     // Catch: Throwable -> L26
            Context r1 = (Context) r0;     // Catch: Throwable -> L26
        L25:
            return r1;
        L30:
            return null;
        L17:
            if (r5.intValue() != 6) goto L19;
            Object r2 = r3.invoke(null, new Object[]{r16, r17, r18, r19, Integer.valueOf(r20), r21});     // Catch: Throwable -> L26
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.content.Context");     // Catch: Throwable -> L26
            r1 = (Context) r2;     // Catch: Throwable -> L26
            goto L25
        L27:
            Class<?>[] r6 = r3.getParameterTypes();     // Catch: Throwable -> L26
            if (r6 == null) goto L12;
            r5 = Integer.valueOf(r6.length);     // Catch: Throwable -> L26
            goto L14
        L32:
            return null;
        L31:
            return null;
        L28:
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\n¨\u0006\r"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/ChatWindowReflectionCompat$LoadedApkRef;", "", "<init>", "()V", "fromActivityThread", "app", "Landroid/app/Application;", "viaNoCheck", "fromContextImpl", "context", "Landroid/content/Context;", "obtain", "anyContext", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LoadedApkRef {
        public static final LoadedApkRef INSTANCE = null;

        static {
            INSTANCE = new LoadedApkRef();
        }

        private LoadedApkRef() {
        }

        public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
            return Class.forName(r0);
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_obric_assistant_interaction_impl_window_ChatWindowReflectionCompat$LoadedApkRef_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
            ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
            FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (a.a() == true) goto L34;
            Class r2 = access$000(r3);     // Catch: Throwable -> L8
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
        L7:
            return r2;
        L8:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r3);
        L12:
            throw th;
        L34:
            Class r4 = access$000(r3);     // Catch: Throwable -> L17
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
        L16:
            return r4;
        L17:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r3);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r3);
        }

        public final Object fromActivityThread(Application r6) {
            Intrinsics.checkNotNullParameter(r6, "app");
            Object r0 = ActivityThreadRef.INSTANCE.current();
            if (r0 != null) goto L5;
            return null;
        L5:
            String r7 = r6.getPackageName();
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L23
            Field r4 = r0.getClass().getDeclaredField("mPackages");     // Catch: Throwable -> L23
            r4.setAccessible(true);     // Catch: Throwable -> L23
            Object r5 = r4.get(r0);     // Catch: Throwable -> L23
            if ((r5 instanceof Map) == false) goto L9;
            Map r8 = (Map) r5;     // Catch: Throwable -> L23
        L10:
            if (r8 == null) goto L12;
            Object r9 = r8.get(r7);     // Catch: Throwable -> L23
        L14:
            if ((r9 instanceof WeakReference) == false) goto L16;
            WeakReference r10 = (WeakReference) r9;     // Catch: Throwable -> L23
        L17:
            if (r10 == null) goto L21;
            Object r11 = r10.get();     // Catch: Throwable -> L23
            if (r11 == null) goto L21;
            return r11;
        L21:
            Result.constructor-impl(null);     // Catch: Throwable -> L23
        L45:
            Field r12 = r0.getClass().getDeclaredField("mResourcePackages");     // Catch: Throwable -> L42
            r12.setAccessible(true);     // Catch: Throwable -> L42
            Object r1 = r12.get(r0);     // Catch: Throwable -> L42
            if ((r1 instanceof Map) == false) goto L28;
            Map r2 = (Map) r1;     // Catch: Throwable -> L42
        L29:
            if (r2 == null) goto L31;
            Object r13 = r2.get(r7);     // Catch: Throwable -> L42
        L33:
            if ((r13 instanceof WeakReference) == false) goto L35;
            WeakReference r14 = (WeakReference) r13;     // Catch: Throwable -> L42
        L36:
            if (r14 == null) goto L40;
            Object r15 = r14.get();     // Catch: Throwable -> L42
            if (r15 == null) goto L40;
            return r15;
        L40:
            Result.constructor-impl(null);     // Catch: Throwable -> L42
        L44:
            return null;
        L35:
            r14 = null;
            goto L36
        L31:
            r13 = null;
            goto L33
        L28:
            r2 = null;
        L42:
            th = move-exception;
            Result.Companion r16 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L44
        L16:
            r10 = null;
            goto L17
        L12:
            r9 = null;
            goto L14
        L9:
            r8 = null;
        L23:
            th = move-exception;
            Result.Companion r17 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L45
        }

        public final Object fromContextImpl(Context r4) {
            Intrinsics.checkNotNullParameter(r4, "context");
        L4:
            if ((r4 instanceof ContextWrapper) == false) goto L18;
            r4 = ((ContextWrapper) r4).getBaseContext();
            goto L4
        L18:
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
            Field r2 = r4.getClass().getDeclaredField("mLoadedApk");     // Catch: Throwable -> L9
            r2.setAccessible(true);     // Catch: Throwable -> L9
            return r2.get(r4);
        L9:
            th = move-exception;
            Result.Companion r3 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            Field r5 = r4.getClass().getDeclaredField("mPackageInfo");     // Catch: Throwable -> L13
            r5.setAccessible(true);     // Catch: Throwable -> L13
            return r5.get(r4);
        L13:
            th = move-exception;
            Result.Companion r0 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            return null;
        }

        public final Object viaNoCheck(Application r14) {
            Intrinsics.checkNotNullParameter(r14, "app");
            Object r0 = ActivityThreadRef.INSTANCE.current();
            if (r0 != null) goto L5;
            return null;
        L5:
            Class<?> r2 = r0.getClass();
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L8
            Object r5 = Result.constructor-impl(r14.getPackageManager().getApplicationInfo(r14.getPackageName(), 0));     // Catch: Throwable -> L8
        L11:
            if (Result.isFailure-impl(r5) == false) goto L13;
            r5 = null;
        L13:
            ApplicationInfo r6 = (ApplicationInfo) r5;
            if (r6 != null) goto L70;
            return null;
        L70:
            Object r7 = Result.constructor-impl(INVOKESTATIC_com_obric_assistant_interaction_impl_window_ChatWindowReflectionCompat$LoadedApkRef_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.content.res.CompatibilityInfo"));     // Catch: Throwable -> L18
        L21:
            if (Result.isFailure-impl(r7) == false) goto L23;
            r7 = null;
        L23:
            Class r8 = (Class) r7;
            if (r8 != null) goto L66;
            return null;
        L66:
            Field r9 = r8.getDeclaredField("DEFAULT_COMPATIBILITY_INFO");     // Catch: Throwable -> L29
            r9.setAccessible(true);     // Catch: Throwable -> L29
            Object r10 = Result.constructor-impl(r9.get(null));     // Catch: Throwable -> L29
        L32:
            if (Result.isFailure-impl(r10) == false) goto L34;
            r10 = null;
        L34:
            if (r10 != null) goto L36;
            return null;
        L36:
            Iterator r11 = CollectionsKt.listOf(new Class[][]{new Class[]{ApplicationInfo.class, r8}, new Class[]{ApplicationInfo.class, r8, ClassLoader.class}}).iterator();
        L38:
            if (r11.hasNext() == false) goto L65;
            Class[] r12 = (Class[]) r11.next();
            Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L42
            Method r15 = r2.getDeclaredMethod("getPackageInfoNoCheck", (Class[]) Arrays.copyOf(r12, r12.length));     // Catch: Throwable -> L42
            r15.setAccessible(true);     // Catch: Throwable -> L42
            Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L42
        L45:
            if (Result.isFailure-impl(r16) == false) goto L47;
            r16 = null;
        L47:
            Method r17 = (Method) r16;
            if (r17 == null) goto L38;
            int r18 = r12.length;
            if (r18 == 2) goto L55;
            if (r18 != 3) goto L38;
            Object[] r19 = {r6, r10, r14.getClassLoader()};
        L72:
            Object r20 = Result.constructor-impl(r17.invoke(r0, Arrays.copyOf(r19, r19.length)));     // Catch: Throwable -> L58
        L61:
            if (Result.isFailure-impl(r20) == false) goto L63;
            r20 = null;
        L63:
            if (r20 == null) goto L38;
            return r20;
        L58:
            th = move-exception;
            Result.Companion r110 = Result.Companion;
            r20 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L61
        L55:
            r19 = new Object[]{r6, r10};
        L42:
            th = move-exception;
            Result.Companion r111 = Result.Companion;
            r16 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L45
        L65:
            return null;
        L29:
            th = move-exception;
            Result.Companion r21 = Result.Companion;
            r10 = Result.constructor-impl(ResultKt.createFailure(th));
        L18:
            th = move-exception;
            Result.Companion r22 = Result.Companion;
            r7 = Result.constructor-impl(ResultKt.createFailure(th));
        L8:
            th = move-exception;
            Result.Companion r23 = Result.Companion;
            r5 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L11
        }

        public final Object obtain(Application r2, Context r3) {
            Intrinsics.checkNotNullParameter(r2, "app");
            Intrinsics.checkNotNullParameter(r3, "anyContext");
            Object r0 = fromActivityThread(r2);
            if (r0 != null) goto L8;
            Object r1 = viaNoCheck(r2);
            if (r1 == null) goto L7;
            return r1;
        L7:
            return fromContextImpl(r3);
        L8:
            return r0;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rR\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/ChatWindowReflectionCompat$ViewRootImplRef;", "", "<init>", "()V", "windowTokenMethod", "Ljava/lang/reflect/Method;", "getWindowTokenMethod", "()Ljava/lang/reflect/Method;", "windowTokenMethod$delegate", "Lkotlin/Lazy;", "getWindowToken", "Landroid/os/IBinder;", "parent", "Landroid/view/ViewParent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewRootImplRef {
        public static final ViewRootImplRef INSTANCE = null;
        private static final Lazy windowTokenMethod$delegate = null;

        private ViewRootImplRef() {
        }

        public static /* synthetic */ Method a() {
            return windowTokenMethod_delegate$lambda$3();
        }

        public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
            return Class.forName(r0);
        }

        static {
            INSTANCE = new ViewRootImplRef();
            windowTokenMethod$delegate = LazyKt.lazy(new o());
        }

        private final Method getWindowTokenMethod() {
            return (Method) windowTokenMethod$delegate.getValue();
        }

        private static final Method windowTokenMethod_delegate$lambda$3() {
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
            Method r1 = INVOKESTATIC_com_obric_assistant_interaction_impl_window_ChatWindowReflectionCompat$ViewRootImplRef_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.ViewRootImpl").getDeclaredMethod("getWindowToken", new Class[0]);     // Catch: Throwable -> L4
            r1.setAccessible(true);     // Catch: Throwable -> L4
            Object r2 = Result.constructor-impl(r1);     // Catch: Throwable -> L4
        L6:
            Throwable r3 = Result.exceptionOrNull-impl(r2);
            if (r3 == null) goto L10;
            FLogger.a.w("ChatWindowReflectionCompat", "ViewRootImpl.getWindowToken is unavailable", r3);
        L10:
            if (Result.isFailure-impl(r2) == false) goto L13;
            r2 = null;
        L13:
            return (Method) r2;
        L4:
            th = move-exception;
            Result.Companion r4 = Result.Companion;
            r2 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L6
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_obric_assistant_interaction_impl_window_ChatWindowReflectionCompat$ViewRootImplRef_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
            ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
            FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (a.a() == true) goto L34;
            Class r2 = access$000(r3);     // Catch: Throwable -> L8
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
        L7:
            return r2;
        L8:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r3);
        L12:
            throw th;
        L34:
            Class r4 = access$000(r3);     // Catch: Throwable -> L17
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
        L16:
            return r4;
        L17:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r3);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r3);
        }

        public final IBinder getWindowToken(ViewParent r6) {
            Method r0 = getWindowTokenMethod();
            Object r1 = null;
            if (r0 != null) goto L6;
            return null;
        L6:
            if (r0.getDeclaringClass().isInstance(r6) == true) goto L25;
            return null;
        L25:
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
            Object r7 = r0.invoke(r6, new Object[0]);     // Catch: Throwable -> L14
            if ((r7 instanceof IBinder) == false) goto L11;
            IBinder r8 = (IBinder) r7;     // Catch: Throwable -> L14
        L12:
            Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L14
        L16:
            Throwable r3 = Result.exceptionOrNull-impl(r9);
            if (r3 == null) goto L20;
            FLogger.a.w("ChatWindowReflectionCompat", "Cannot read parent Window token", r3);
        L20:
            if (Result.isFailure-impl(r9) == true) goto L24;
            r1 = r9;
        L24:
            return (IBinder) r1;
        L11:
            r8 = null;
        L14:
            th = move-exception;
            Result.Companion r4 = Result.Companion;
            r9 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L16
        }
    }

    static {
        INSTANCE = new ChatWindowReflectionCompat();
    }

    private ChatWindowReflectionCompat() {
    }
}
