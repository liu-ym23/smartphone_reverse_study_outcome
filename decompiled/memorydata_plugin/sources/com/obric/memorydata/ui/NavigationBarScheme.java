package com.obric.memorydata.ui;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/ui/NavigationBarScheme;", "", "contrastEnforced", "", "<init>", "(Ljava/lang/String;IZ)V", "getContrastEnforced", "()Z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B1", "B2", "B3", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum NavigationBarScheme extends Enum<NavigationBarScheme> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ NavigationBarScheme[] $VALUES = null;
    public static final NavigationBarScheme A = null;
    public static final NavigationBarScheme B1 = null;
    public static final NavigationBarScheme B2 = null;
    public static final NavigationBarScheme B3 = null;
    private final boolean contrastEnforced;

    private static final /* synthetic */ NavigationBarScheme[] $values() {
        return new NavigationBarScheme[]{A, B1, B2, B3};
    }

    static {
        A = new NavigationBarScheme(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, 0, false);
        B1 = new NavigationBarScheme("B1", 1, true);
        B2 = new NavigationBarScheme("B2", 2, true);
        B3 = new NavigationBarScheme("B3", 3, false);
        NavigationBarScheme[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private NavigationBarScheme(String r1, int r2, boolean r3) {
        super(r1, r2);
        this.contrastEnforced = r3;
    }

    public static EnumEntries<NavigationBarScheme> getEntries() {
        return $ENTRIES;
    }

    public static NavigationBarScheme valueOf(String r2) {
        return (NavigationBarScheme) ZeusTransformUtils.preCheckCast(Enum.valueOf(NavigationBarScheme.class, r2), NavigationBarScheme.class, "com.obric.memorydata.plugin");
    }

    public static NavigationBarScheme[] values() {
        return (NavigationBarScheme[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NavigationBarScheme[].class, "com.obric.memorydata.plugin");
    }

    public final boolean getContrastEnforced() {
        return this.contrastEnforced;
    }
}
