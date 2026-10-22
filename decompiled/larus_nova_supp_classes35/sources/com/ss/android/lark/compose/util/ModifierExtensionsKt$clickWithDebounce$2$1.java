package com.ss.android.lark.compose.util;

import androidx.compose.runtime.MutableState;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlin.time.TimeMark;
import kotlin.time.TimeSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ModifierExtensionsKt$clickWithDebounce$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $debounceMillis;
    final /* synthetic */ MutableState<TimeMark> $lastClickTime$delegate;
    final /* synthetic */ Function0<Unit> $onClick;

    public ModifierExtensionsKt$clickWithDebounce$2$1(long r1, Function0<Unit> r3, MutableState<TimeMark> r4) {
        this.$debounceMillis = r1;
        this.$onClick = r3;
        this.$lastClickTime$delegate = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m945invoke() {
        TimeMark r0 = (TimeMark) this.$lastClickTime$delegate.getValue();
        if (r0 == null) goto L5;
        Duration r1 = Duration.box-impl(r0.elapsedNow-UwyO8pc());
    L6:
        long r2 = this.$debounceMillis;
        if (r1 == null) goto L12;
        long r3 = r1.unbox-impl();
        Duration.Companion r4 = Duration.Companion;
        if (Duration.compareTo-LRDsOJo(r3, DurationKt.toDuration(r2, DurationUnit.MILLISECONDS)) > 0) goto L12;
        boolean r5 = false;
    L13:
        if (r5 == false) goto L16;
        this.$lastClickTime$delegate.setValue(TimeSource.Monotonic.ValueTimeMark.box-impl(TimeSource.Monotonic.INSTANCE.markNow-z9LOYto()));
        this.$onClick.invoke();
        return;
    L16:
        return;
    L12:
        r5 = true;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m945invoke();
        return Unit.INSTANCE;
    }
}
