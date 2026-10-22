package com.ss.android.lark.chat.base.model.dispatch;

import android.os.Handler;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.media.v1.CancelPreprocessResourceRequest;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ResourcePreprocessorV2 implements qzb.a {
    public static final ResourcePreprocessorV2 a = null;
    public static final Map<String, g> b = null;
    public static final Set<com.ss.android.lark.chat.base.model.dispatch.d> c = null;
    public static final Lazy d = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chat/base/model/dispatch/ResourcePreprocessorV2$Action;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "CHECK", "UNCHECK", "TOGGLE_ORIGIN", "toBoolean", BuildConfig.FLAVOR, "im-sdk-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Action extends Enum<Action> {
        public static final Action CHECK = null;
        public static final Action TOGGLE_ORIGIN = null;
        public static final Action UNCHECK = null;
        public static final /* synthetic */ Action[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[Action.values().length];
                r0[Action.CHECK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                a = r0;
            }
        }

        public static EnumEntries<Action> getEntries() {
            return b;
        }

        static {
            Action r0 = new Action("CHECK", 0);
            CHECK = r0;
            Action r1 = new Action("UNCHECK", 1);
            UNCHECK = r1;
            Action r3 = new Action("TOGGLE_ORIGIN", 2);
            TOGGLE_ORIGIN = r3;
            Action[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static Action[] values() {
            return (Action[]) a.clone();
        }

        public final boolean toBoolean() {
            if (a.a[ordinal()] == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public static Action valueOf(String r1) {
            return (Action) r27.a.a(Action.class, r1);
        }

        public Action(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void a(PreprocessParams r2, Function1 r3) {
            Intrinsics.checkNotNullParameter((com.ss.android.lark.chat.base.model.dispatch.c) r2, "params");
            Intrinsics.checkNotNullParameter(r3, "onSuccessCallback");
        }
    }

    public static final class b {
        public static final b a = null;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ResourceType.values().length];
                r0[ResourceType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                a = r0;
            }
        }

        static {
            a = new b();
        }

        public b() {
        }

        public static void a(com.ss.android.lark.chat.base.model.dispatch.d r3, ResourcePreprocessorV2$MediaPreprocessor$preprocessInner$1 r4) {
            File r0 = com.ss.android.lark.vfs.d.a().G(r3.d, true);
            if (r0.exists() == true) goto L7;
            Log.e("ResourcePreprocessorV2", "preCompressImage / Invalid path, file not exists, path: " + ((String) r3.c.getValue()) + '}');
            return;
        L7:
            if (r3.e == true) goto L9;
            int r5 = blb.c.a;
            blb.c.d(ImSdk.a.getContext(), r0.getPath(), ((Boolean) PreprocessFgUtil.a.getValue()).booleanValue(), r4);
            return;
        L9:
            r4.onSuccess(r0.getPath());
        }

        /* JADX WARN: Type inference failed for: r0v10, types: [com.ss.android.lark.chat.base.model.dispatch.ResourcePreprocessorV2$MediaPreprocessor$preprocessInner$1] */
        public final void b(PreprocessParams r4, final Function1 r5) {
            final com.ss.android.lark.chat.base.model.dispatch.d r6 = (com.ss.android.lark.chat.base.model.dispatch.d) r4;
            Intrinsics.checkNotNullParameter(r6, "params");
            Intrinsics.checkNotNullParameter(r5, "onSuccessCallback");
            ResourcePreprocessorV2 r0 = ResourcePreprocessorV2.a;
            f r1 = r6.b;
            boolean r2 = r1.a;
            if (r2 == true) goto L5;
            r2 = ResourcePreprocessorV2.c(r1);
        L5:
            Log.i("ResourcePreprocessorV2", "checkIfPreUpload / doPreUpload: " + r2 + ", params: " + r6);
            if (r2 == false) goto L15;
            ((CopyOnWriteArraySet) ResourcePreprocessorV2.c).add(r6);
        L15:
        L12:
            e = move-exception;
            Log.e("ResourcePreprocessorV2", "preprocessInner / Params: " + r6 + ", " + e);
            return;
        L9:
            if (a.a[r6.getType().ordinal()] != 1) goto L17;
            a(r6, new ResourcePreprocessorV2$MediaPreprocessor$preprocessInner$1(r6, r5));     // Catch: IOException -> L12
            return;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Action.values().length];
            r0[Action.CHECK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Action.UNCHECK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Action.TOGGLE_ORIGIN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class d<T> implements SdkSender.IParser {
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final /* bridge */ /* synthetic */ Object parse(byte[] r1) {
            return null;
        }
    }

    public ResourcePreprocessorV2() {
    }

    static {
        ResourcePreprocessorV2 r0 = new ResourcePreprocessorV2();
        a = r0;
        b = Collections.synchronizedMap(new HashMap());
        c = new CopyOnWriteArraySet();
        d = LazyKt.lazy(ResourcePreprocessorV2$mHandler$2.INSTANCE);
        ImSdkProxy.e().registerUserSwitchListener(r0);
    }

    public final Handler d() {
        return (Handler) d.getValue();
    }

    public static void a(g r2) {
        Log.i("ResourcePreprocessorV2", "callSdkCancelPreUpload / Call sdk to cancel pre-upload, " + r2);
        SdkSender.syncSend(Command.CANCEL_PREPROCESS_RESOURCE, new CancelPreprocessResourceRequest.Builder().key(r2.b), d.a);
    }

    public static boolean c(f r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        if (r3.b == true) goto L5;
    L9:
        boolean r0 = false;
    L10:
        if (r0 == true) goto L12;
        return false;
    L12:
        if (r3.e == true) goto L16;
        return true;
    L16:
        return false;
    L5:
        if (r3.c == true) goto L9;
        if (r3.d == true) goto L9;
        r0 = true;
        goto L10
    }

    public final void b(PreprocessParams r3) {
        d().removeMessages(0, r3);
        TypeIntrinsics.asMutableCollection(c).remove(r3);
        g r4 = e(this, r3.b());
        if (r4 == null) goto L6;
        a(r4);
        return;
    }

    public static g e(ResourcePreprocessorV2 r0, String r1) {
        r0.getClass();
        if (r1 != null) goto L6;
        return null;
    L6:
        return b.remove(r1);
    }

    public final void f(PreprocessParams r7, Action r8) {
        Intrinsics.checkNotNullParameter(r8, Keys.API_PARAM_KEY_ACTION);
        if (r7 != null) goto L5;
        return;
    L5:
        Lazy r0 = PreprocessFgUtil.a;
        Intrinsics.checkNotNullParameter(r7, "params");
        int r1 = PreprocessFgUtil.a.a[r7.getType().ordinal()];
        boolean r4 = true;
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L13;
        throw new NoWhenBranchMatchedException();
    L13:
        if (r7.a() == true) goto L16;
        Log.e("ResourcePreprocessorV2", "preprocessResource / Invalid params: " + r7);
        return;
    L16:
        int r9 = c.a[r8.ordinal()];
        if (r9 == 1) goto L30;
        if (r9 == 2) goto L29;
        if (r9 != 3) goto L28;
        if ((r7 instanceof com.ss.android.lark.chat.base.model.dispatch.d) == false) goto L23;
        com.ss.android.lark.chat.base.model.dispatch.d r10 = (com.ss.android.lark.chat.base.model.dispatch.d) r7;
    L24:
        if (r10 == null) goto L26;
        b(new com.ss.android.lark.chat.base.model.dispatch.d(r10.getType(), r10.d, true ^ r10.e, r10.b));
        d().sendMessage(d().obtainMessage(0, r7));
        return;
    L26:
        return;
    L23:
        r10 = null;
        goto L24
    L28:
        throw new NoWhenBranchMatchedException();
    L29:
        Log.i("ResourcePreprocessorV2", "preprocessResource / Uncheck params: " + r7);
        b(r7);
        int r11 = i.c;
        Intrinsics.checkNotNullParameter(r7, "params");
        i.d = r7;
        i.f = System.currentTimeMillis();
        i.e = false;
        return;
    L30:
        Log.i("ResourcePreprocessorV2", "preprocessResource / Check params: " + r7);
        d().sendMessage(d().obtainMessage(0, r7));
        int r12 = i.c;
        Intrinsics.checkNotNullParameter(r7, "params");
        if (Intrinsics.areEqual(i.d, r7) == false) goto L33;
        Log.i("PreprocessHitPointUtil", "onCheck / Repeat select params: " + r7);
    L34:
        i.b(r4);
        return;
    L33:
        r4 = false;
        goto L34
    }
}
