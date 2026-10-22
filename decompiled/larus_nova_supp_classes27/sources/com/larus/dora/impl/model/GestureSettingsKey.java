package com.larus.dora.impl.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0005\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0015"}, d2 = {"Lcom/larus/dora/impl/model/GestureSettingsKey;", "", "role", "", "status", "key", "<init>", "(Ljava/lang/String;IBBB)V", "getRole", "()B", "getStatus", "getKey", "MEDIA_LEFT_DOUBLE_CLICK", "MEDIA_RIGHT_DOUBLE_CLICK", "CALLING_LEFT_DOUBLE_CLICK", "CALLING_RIGHT_DOUBLE_CLICK", "normalize", "", "toByteArray", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GestureSettingsKey extends Enum<GestureSettingsKey> {
    public static final GestureSettingsKey CALLING_LEFT_DOUBLE_CLICK = null;
    public static final GestureSettingsKey CALLING_RIGHT_DOUBLE_CLICK = null;
    public static final a Companion = null;
    public static final GestureSettingsKey MEDIA_LEFT_DOUBLE_CLICK = null;
    public static final GestureSettingsKey MEDIA_RIGHT_DOUBLE_CLICK = null;
    public static final /* synthetic */ GestureSettingsKey[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final byte key;
    private final byte role;
    private final byte status;

    public static EnumEntries<GestureSettingsKey> getEntries() {
        return b;
    }

    public final byte[] toByteArray() {
        return new byte[]{this.role, this.status, this.key};
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.dora.impl.model.GestureSettingsKey$a] */
    static {
        GestureSettingsKey r0 = new GestureSettingsKey("MEDIA_LEFT_DOUBLE_CLICK", 0, (byte) 16, (byte) 0);
        MEDIA_LEFT_DOUBLE_CLICK = r0;
        GestureSettingsKey r1 = new GestureSettingsKey("MEDIA_RIGHT_DOUBLE_CLICK", 1, (byte) 0, (byte) 0);
        MEDIA_RIGHT_DOUBLE_CLICK = r1;
        GestureSettingsKey r4 = new GestureSettingsKey("CALLING_LEFT_DOUBLE_CLICK", 2, (byte) 16, (byte) 1);
        CALLING_LEFT_DOUBLE_CLICK = r4;
        GestureSettingsKey r3 = new GestureSettingsKey("CALLING_RIGHT_DOUBLE_CLICK", 3, (byte) 0, (byte) 1);
        CALLING_RIGHT_DOUBLE_CLICK = r3;
        GestureSettingsKey[] r6 = {r0, r1, r4, r3};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
        Companion = new a();
    }

    public static GestureSettingsKey[] values() {
        return (GestureSettingsKey[]) a.clone();
    }

    public final String normalize() {
        return this.role + ", " + this.status + ", " + this.key;
    }

    public final byte getKey() {
        return this.key;
    }

    public final byte getRole() {
        return this.role;
    }

    public final byte getStatus() {
        return this.status;
    }

    public static GestureSettingsKey valueOf(String r1) {
        return (GestureSettingsKey) r27.a.a(GestureSettingsKey.class, r1);
    }

    public GestureSettingsKey(String r1, int r2, byte r3, byte r4) {
        super(r1, r2);
        this.role = r3;
        this.status = r4;
        this.key = 1;
    }
}
