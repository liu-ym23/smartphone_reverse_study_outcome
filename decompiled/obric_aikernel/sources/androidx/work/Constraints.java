package androidx.work;

import android.net.Uri;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.work.impl.utils.DurationApi26Impl;
import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class Constraints {
    public static final Companion Companion = null;

    @JvmField
    public static final Constraints NONE = null;

    @ColumnInfo(name = "trigger_max_content_delay")
    private final long contentTriggerMaxDelayMillis;

    @ColumnInfo(name = "trigger_content_update_delay")
    private final long contentTriggerUpdateDelayMillis;

    @ColumnInfo(name = "content_uri_triggers")
    private final Set<ContentUriTrigger> contentUriTriggers;

    @ColumnInfo(name = "required_network_type")
    private final NetworkType requiredNetworkType;

    @ColumnInfo(name = "requires_battery_not_low")
    private final boolean requiresBatteryNotLow;

    @ColumnInfo(name = "requires_charging")
    private final boolean requiresCharging;

    @ColumnInfo(name = "requires_device_idle")
    private final boolean requiresDeviceIdle;

    @ColumnInfo(name = "requires_storage_not_low")
    private final boolean requiresStorageNotLow;

    public static final class Builder {
        private Set<ContentUriTrigger> contentUriTriggers;
        private NetworkType requiredNetworkType;
        private boolean requiresBatteryNotLow;
        private boolean requiresCharging;
        private boolean requiresDeviceIdle;
        private boolean requiresStorageNotLow;
        private long triggerContentMaxDelay;
        private long triggerContentUpdateDelay;

        public Builder() {
            this.requiredNetworkType = NetworkType.NOT_REQUIRED;
            this.triggerContentUpdateDelay = -1;
            this.triggerContentMaxDelay = -1;
            this.contentUriTriggers = new LinkedHashSet();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder(Constraints r10) {
            Intrinsics.checkNotNullParameter(r10, "constraints");
            this.requiredNetworkType = NetworkType.NOT_REQUIRED;
            this.triggerContentUpdateDelay = -1;
            this.triggerContentMaxDelay = -1;
            this.contentUriTriggers = new LinkedHashSet();
            this.requiresCharging = r10.requiresCharging();
            int r11 = Build.VERSION.SDK_INT;
            if (r11 >= 23) goto L5;
        L7:
            boolean r12 = false;
        L8:
            this.requiresDeviceIdle = r12;
            this.requiredNetworkType = r10.getRequiredNetworkType();
            this.requiresBatteryNotLow = r10.requiresBatteryNotLow();
            this.requiresStorageNotLow = r10.requiresStorageNotLow();
            if (r11 < 24) goto L12;
            this.triggerContentUpdateDelay = r10.getContentTriggerUpdateDelayMillis();
            this.triggerContentMaxDelay = r10.getContentTriggerMaxDelayMillis();
            this.contentUriTriggers = CollectionsKt.toMutableSet(r10.getContentUriTriggers());
            return;
        L12:
            return;
        L5:
            if (r10.requiresDeviceIdle() == false) goto L7;
            r12 = true;
            goto L8
        }

        @RequiresApi(24)
        public final Builder addContentUriTrigger(Uri r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "uri");
            this.contentUriTriggers.add(new ContentUriTrigger(r10, r11));
            return this;
        }

        public final Constraints build() {
            int r10 = Build.VERSION.SDK_INT;
            if (r10 < 24) goto L5;
            Set r11 = CollectionsKt.toSet(this.contentUriTriggers);
            Set r14 = r11;
            long r12 = this.triggerContentUpdateDelay;
            long r13 = this.triggerContentMaxDelay;
        L6:
            boolean r15 = this.requiresCharging;
            if (r10 >= 23) goto L9;
        L11:
            boolean r16 = false;
        L13:
            return new Constraints(this.requiredNetworkType, r15, r16, this.requiresBatteryNotLow, this.requiresStorageNotLow, r12, r13, r14);
        L9:
            if (this.requiresDeviceIdle == false) goto L11;
            r16 = true;
            goto L13
        L5:
            r12 = -1;
            r13 = -1;
            r14 = SetsKt.emptySet();
            goto L6
        }

        public final Builder setRequiredNetworkType(NetworkType r10) {
            Intrinsics.checkNotNullParameter(r10, "networkType");
            this.requiredNetworkType = r10;
            return this;
        }

        public final Builder setRequiresBatteryNotLow(boolean r10) {
            this.requiresBatteryNotLow = r10;
            return this;
        }

        public final Builder setRequiresCharging(boolean r10) {
            this.requiresCharging = r10;
            return this;
        }

        @RequiresApi(23)
        public final Builder setRequiresDeviceIdle(boolean r10) {
            this.requiresDeviceIdle = r10;
            return this;
        }

        public final Builder setRequiresStorageNotLow(boolean r10) {
            this.requiresStorageNotLow = r10;
            return this;
        }

        @RequiresApi(24)
        public final Builder setTriggerContentMaxDelay(long r10, TimeUnit r11) {
            Intrinsics.checkNotNullParameter(r11, "timeUnit");
            this.triggerContentMaxDelay = r11.toMillis(r10);
            return this;
        }

        @RequiresApi(26)
        public final Builder setTriggerContentMaxDelay(Duration r10) {
            Intrinsics.checkNotNullParameter(r10, "duration");
            this.triggerContentMaxDelay = DurationApi26Impl.toMillisCompat(r10);
            return this;
        }

        @RequiresApi(24)
        public final Builder setTriggerContentUpdateDelay(long r10, TimeUnit r11) {
            Intrinsics.checkNotNullParameter(r11, "timeUnit");
            this.triggerContentUpdateDelay = r11.toMillis(r10);
            return this;
        }

        @RequiresApi(26)
        public final Builder setTriggerContentUpdateDelay(Duration r10) {
            Intrinsics.checkNotNullParameter(r10, "duration");
            this.triggerContentUpdateDelay = DurationApi26Impl.toMillisCompat(r10);
            return this;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class ContentUriTrigger {
        private final boolean isTriggeredForDescendants;
        private final Uri uri;

        public ContentUriTrigger(Uri r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "uri");
            this.uri = r10;
            this.isTriggeredForDescendants = r11;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if (r10 == null) goto L8;
            Class<?> r11 = r10.getClass();
        L10:
            if (Intrinsics.areEqual(ContentUriTrigger.class, r11) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type androidx.work.Constraints.ContentUriTrigger");
            ContentUriTrigger r12 = (ContentUriTrigger) r10;
            if (Intrinsics.areEqual(this.uri, r12.uri) == true) goto L16;
            return false;
        L16:
            if (this.isTriggeredForDescendants == r12.isTriggeredForDescendants) goto L18;
            return false;
        L18:
            return true;
        L8:
            r11 = null;
            goto L10
        }

        public final Uri getUri() {
            return this.uri;
        }

        public int hashCode() {
            return (this.uri.hashCode() * 31) + Boolean.hashCode(this.isTriggeredForDescendants);
        }

        public final boolean isTriggeredForDescendants() {
            return this.isTriggeredForDescendants;
        }
    }

    static {
        Companion = new Companion(null);
        NONE = new Constraints(null, false, false, false, false, 0, 0, null, 255, null);
    }

    public Constraints() {
        this(null, false, false, false, false, 0, 0, null, 255, null);
    }

    public Constraints(Constraints r13) {
        Intrinsics.checkNotNullParameter(r13, "other");
        boolean r10 = r13.requiresCharging;
        boolean r11 = r13.requiresDeviceIdle;
        NetworkType r12 = r13.requiredNetworkType;
        boolean r14 = r13.requiresBatteryNotLow;
        boolean r15 = r13.requiresStorageNotLow;
        Set<ContentUriTrigger> r16 = r13.contentUriTriggers;
        this(r12, r10, r11, r14, r15, r13.contentTriggerUpdateDelayMillis, r13.contentTriggerMaxDelayMillis, r16);
    }

    public Constraints(NetworkType r10, boolean r11, boolean r12, boolean r13, boolean r14, long r15, long r16, Set<ContentUriTrigger> r17) {
        Intrinsics.checkNotNullParameter(r10, "requiredNetworkType");
        Intrinsics.checkNotNullParameter(r17, "contentUriTriggers");
        this.requiredNetworkType = r10;
        this.requiresCharging = r11;
        this.requiresDeviceIdle = r12;
        this.requiresBatteryNotLow = r13;
        this.requiresStorageNotLow = r14;
        this.contentTriggerUpdateDelayMillis = r15;
        this.contentTriggerMaxDelayMillis = r16;
        this.contentUriTriggers = r17;
    }

    public /* synthetic */ Constraints(NetworkType r12, boolean r13, boolean r14, boolean r15, boolean r16, long r17, long r19, Set r21, int r22, DefaultConstructorMarker r23) {
        if ((r22 & 1) == 0) goto L5;
        NetworkType r10 = NetworkType.NOT_REQUIRED;
    L6:
        boolean r11 = false;
        if ((r22 & 2) == 0) goto L9;
        boolean r18 = false;
    L11:
        if ((r22 & 4) == 0) goto L13;
        boolean r20 = false;
    L15:
        if ((r22 & 8) == 0) goto L17;
        boolean r24 = false;
    L19:
        if ((r22 & 16) != 0) goto L22;
        r11 = r16;
    L22:
        long r25 = -1;
        if ((r22 & 32) == 0) goto L25;
        long r26 = -1;
    L27:
        if ((r22 & 64) != 0) goto L31;
        r25 = r19;
    L31:
        if ((r22 & 128) == 0) goto L33;
        Set r27 = SetsKt.emptySet();
    L34:
        this(r10, r18, r20, r24, r11, r26, r25, r27);
        return;
    L33:
        r27 = r21;
        goto L34
    L25:
        r26 = r17;
        goto L27
    L17:
        r24 = r15;
        goto L19
    L13:
        r20 = r14;
        goto L15
    L9:
        r18 = r13;
        goto L11
    L5:
        r10 = r12;
        goto L6
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(Constraints.class, r10.getClass()) == false) goto L34;
        Constraints r11 = (Constraints) r10;
        if (this.requiresCharging == r11.requiresCharging) goto L14;
        return false;
    L14:
        if (this.requiresDeviceIdle == r11.requiresDeviceIdle) goto L17;
        return false;
    L17:
        if (this.requiresBatteryNotLow == r11.requiresBatteryNotLow) goto L20;
        return false;
    L20:
        if (this.requiresStorageNotLow == r11.requiresStorageNotLow) goto L23;
        return false;
    L23:
        if (this.contentTriggerUpdateDelayMillis == r11.contentTriggerUpdateDelayMillis) goto L26;
        return false;
    L26:
        if (this.contentTriggerMaxDelayMillis == r11.contentTriggerMaxDelayMillis) goto L29;
        return false;
    L29:
        if (this.requiredNetworkType == r11.requiredNetworkType) goto L32;
        return false;
    L32:
        return Intrinsics.areEqual(this.contentUriTriggers, r11.contentUriTriggers);
    L34:
        return false;
    }

    public final long getContentTriggerMaxDelayMillis() {
        return this.contentTriggerMaxDelayMillis;
    }

    public final long getContentTriggerUpdateDelayMillis() {
        return this.contentTriggerUpdateDelayMillis;
    }

    public final Set<ContentUriTrigger> getContentUriTriggers() {
        return this.contentUriTriggers;
    }

    public final NetworkType getRequiredNetworkType() {
        return this.requiredNetworkType;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean hasContentUriTriggers() {
        return !this.contentUriTriggers.isEmpty();
    }

    public int hashCode() {
        int r10 = ((((((((this.requiredNetworkType.hashCode() * 31) + (this.requiresCharging ? 1 : 0)) * 31) + (this.requiresDeviceIdle ? 1 : 0)) * 31) + (this.requiresBatteryNotLow ? 1 : 0)) * 31) + (this.requiresStorageNotLow ? 1 : 0)) * 31;
        long r11 = this.contentTriggerUpdateDelayMillis;
        int r12 = (r10 + ((int) (r11 ^ (r11 >>> 32)))) * 31;
        long r13 = this.contentTriggerMaxDelayMillis;
        return ((r12 + ((int) (r13 ^ (r13 >>> 32)))) * 31) + this.contentUriTriggers.hashCode();
    }

    public final boolean requiresBatteryNotLow() {
        return this.requiresBatteryNotLow;
    }

    public final boolean requiresCharging() {
        return this.requiresCharging;
    }

    @RequiresApi(23)
    public final boolean requiresDeviceIdle() {
        return this.requiresDeviceIdle;
    }

    public final boolean requiresStorageNotLow() {
        return this.requiresStorageNotLow;
    }
}
