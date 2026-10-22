package org.threeten.bp.format;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.threeten.bp.temporal.TemporalField;

/* JADX INFO: loaded from: classes8.dex */
public abstract class DateTimeTextProvider {
    private static final AtomicReference<DateTimeTextProvider> MUTABLE_PROVIDER = null;

    static class ProviderSingleton {
        static final DateTimeTextProvider PROVIDER = null;

        static {
            PROVIDER = initialize();
        }

        static DateTimeTextProvider initialize() {
            DateTimeTextProvider.access$000().compareAndSet(null, new SimpleDateTimeTextProvider());
            return (DateTimeTextProvider) ZeusTransformUtils.preCheckCast(DateTimeTextProvider.access$000().get(), DateTimeTextProvider.class, "com.obric.memorydata.plugin");
        }
    }

    static {
        MUTABLE_PROVIDER = new AtomicReference();
    }

    public DateTimeTextProvider() {
    }

    static /* synthetic */ AtomicReference access$000() {
        return MUTABLE_PROVIDER;
    }

    static DateTimeTextProvider getInstance() {
        return ProviderSingleton.PROVIDER;
    }

    public abstract String getText(TemporalField r1, long r2, TextStyle r4, Locale r5);

    public abstract Iterator<Map.Entry<String, Long>> getTextIterator(TemporalField r1, TextStyle r2, Locale r3);
}
