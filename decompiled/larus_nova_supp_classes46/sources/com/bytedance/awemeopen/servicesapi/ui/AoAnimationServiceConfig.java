package com.bytedance.awemeopen.servicesapi.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class AoAnimationServiceConfig {

    /* JADX INFO: renamed from: com.bytedance.awemeopen.servicesapi.ui.AoAnimationServiceConfig$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    final class AnonymousClass1 extends Lambda implements Function1<Throwable, Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1);
        }

        public final void invoke(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((Throwable) r1);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/awemeopen/servicesapi/ui/AoAnimationServiceConfig$ResMode;", "", "URL", "ASSET", "RAW_RES", "JSON_STREAM", "JSON_STRING", "ZIP_STREAM", "EMPTY", "ao_basic_service_api_release"}, k = 1, mv = {1, 7, 1})
    public static final enum ResMode extends Enum<ResMode> {
        public static final ResMode ASSET = null;
        public static final ResMode EMPTY = null;
        public static final ResMode JSON_STREAM = null;
        public static final ResMode JSON_STRING = null;
        public static final ResMode RAW_RES = null;
        public static final ResMode URL = null;
        public static final ResMode ZIP_STREAM = null;
        public static final /* synthetic */ ResMode[] a = null;

        public static ResMode valueOf(String r1) {
            return (ResMode) r27.a.a(ResMode.class, r1);
        }

        public static ResMode[] values() {
            return (ResMode[]) a.clone();
        }

        static {
            ResMode r0 = new ResMode("URL", 0);
            URL = r0;
            ResMode r1 = new ResMode("ASSET", 1);
            ASSET = r1;
            ResMode r3 = new ResMode("RAW_RES", 2);
            RAW_RES = r3;
            ResMode r5 = new ResMode("JSON_STREAM", 3);
            JSON_STREAM = r5;
            ResMode r7 = new ResMode("JSON_STRING", 4);
            JSON_STRING = r7;
            ResMode r9 = new ResMode("ZIP_STREAM", 5);
            ZIP_STREAM = r9;
            ResMode r11 = new ResMode("EMPTY", 6);
            EMPTY = r11;
            a = new ResMode[]{r0, r1, r3, r5, r7, r9, r11};
        }

        public ResMode(String r1, int r2) {
            super(r1, r2);
        }
    }
}
