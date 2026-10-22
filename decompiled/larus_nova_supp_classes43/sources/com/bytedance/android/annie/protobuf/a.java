package com.bytedance.android.annie.protobuf;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static volatile boolean a;

    /* JADX INFO: renamed from: com.bytedance.android.annie.protobuf.a$a, reason: collision with other inner class name */
    public static final class CallableC0077a<V> implements Callable {
        public static final CallableC0077a<V> a = null;

        static {
            a = new CallableC0077a();
        }

        public CallableC0077a() {
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            ExternalProtobufMessageDefinitions.b.a();
            ExternalProtobufShrinkConfigs.b.a();
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public static final class b implements t9.c {
        public b() {
        }

        @Override // t9.c
        public final t9.b M0(JsonObject r10) {
            Intrinsics.checkNotNullParameter(r10, "def");
            return new com.bytedance.android.annie.protobuf.b(new ExternalProtobufMessageDefinitions("", r10), new ExternalProtobufShrinkConfigs("", new JsonObject()));
        }

        @Override // t9.c
        public final t9.b w0(String r10) {
            int r0 = com.bytedance.android.annie.protobuf.b.c;
            ExternalProtobufMessageDefinitions.Companion r1 = ExternalProtobufMessageDefinitions.b;
            if (r10 == null) goto L5;
            Object r11 = r1.d.get(r10);
        L7:
            if (AnnieConfigSettingKeys.ENABLE_LATCH_PB_COMPLETE.a().booleanValue() == false) goto L18;
            ExternalProtobufShrinkConfigs.Companion r12 = ExternalProtobufShrinkConfigs.b;
            if (r10 == null) goto L11;
            Object r13 = r12.d.get(r10);
        L12:
            ExternalProtobufShrinkConfigs r14 = (ExternalProtobufShrinkConfigs) r13;
            if (r14 == null) goto L15;
        L23:
            if (r11 == null) goto L27;
            if (r14 != null) goto L26;
            return null;
        L26:
            return new com.bytedance.android.annie.protobuf.b((ExternalProtobufMessageDefinitions) r11, r14);
        L27:
            return null;
        L15:
            if (r10 != null) goto L17;
            r10 = "";
        L17:
            r14 = new ExternalProtobufShrinkConfigs(r10, new JsonObject());
            goto L23
        L11:
            r12.getClass();
            r13 = null;
            goto L12
        L18:
            ExternalProtobufShrinkConfigs.Companion r15 = ExternalProtobufShrinkConfigs.b;
            if (r10 == null) goto L21;
            Object r16 = r15.d.get(r10);
        L22:
            r14 = (ExternalProtobufShrinkConfigs) r16;
            goto L23
        L21:
            r15.getClass();
            r16 = null;
            goto L22
        L5:
            r1.getClass();
            r11 = null;
            goto L7
        }
    }

    static {
    }

    public static void a() {
        if (a == false) goto L5;
        return;
    L5:
        a = true;
        Observable.fromCallable(CallableC0077a.a).subscribeOn(Schedulers.io()).subscribe(Functions.emptyConsumer(), Functions.emptyConsumer());
        Annie.registerService$default(t9.c.class, new b(), null, 4, null);
    }
}
