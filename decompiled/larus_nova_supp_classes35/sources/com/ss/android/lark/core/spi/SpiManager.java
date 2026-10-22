package com.ss.android.lark.core.spi;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\b\u0010\t\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/core/spi/SpiManager;", BuildConfig.FLAVOR, "<init>", "()V", "api", "Lcom/ss/android/lark/core/spi/ISpiApi;", "setSpi", BuildConfig.FLAVOR, "spiApi", "getSpi", "Companion", "Holder", "core-component-api-internal_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpiManager {
    public static final Companion Companion = null;
    private volatile ISpiApi api;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/core/spi/SpiManager$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "getInstance", "Lcom/ss/android/lark/core/spi/SpiManager;", "core-component-api-internal_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final SpiManager getInstance() {
            return Holder.INSTANCE.getInstance();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/core/spi/SpiManager$Holder;", BuildConfig.FLAVOR, "<init>", "()V", "instance", "Lcom/ss/android/lark/core/spi/SpiManager;", "getInstance", "()Lcom/ss/android/lark/core/spi/SpiManager;", "core-component-api-internal_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Holder {
        public static final Holder INSTANCE = null;
        private static final SpiManager instance = null;

        private Holder() {
        }

        static {
            INSTANCE = new Holder();
            instance = new SpiManager(null);
        }

        public final SpiManager getInstance() {
            return instance;
        }
    }

    static {
        Companion = new Companion(null);
    }

    private SpiManager() {
    }

    public /* synthetic */ SpiManager(DefaultConstructorMarker r1) {
        this();
    }

    public final ISpiApi getSpi() {
        return this.api;
    }

    public final void setSpi(ISpiApi r2) {
        Intrinsics.checkNotNullParameter(r2, "spiApi");
        this.api = r2;
    }
}
