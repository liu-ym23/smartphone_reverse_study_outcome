package androidx.room.jarjarred.kotlinx.metadata.jvm;

import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmMetadataVersion;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fBY\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rBc\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000fR\u001c\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001b¨\u0006 "}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassHeader;", "", "kind", "", "metadataVersion", "", "data1", "", "", "data2", "extraString", "packageName", "extraInt", "(Ljava/lang/Integer;[I[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "bytecodeVersion", "(Ljava/lang/Integer;[I[I[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getBytecodeVersion$annotations", "()V", "getBytecodeVersion", "()[I", "getData1", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getData2", "getExtraInt", "()I", "getExtraString", "()Ljava/lang/String;", "getKind", "getMetadataVersion", "getPackageName", "Companion", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KotlinClassHeader {
    public static final int CLASS_KIND = 1;

    @JvmField
    public static final int[] COMPATIBLE_BYTECODE_VERSION = null;

    @JvmField
    public static final int[] COMPATIBLE_METADATA_VERSION = null;
    public static final Companion Companion = null;
    public static final int FILE_FACADE_KIND = 2;
    public static final int MULTI_FILE_CLASS_FACADE_KIND = 4;
    public static final int MULTI_FILE_CLASS_PART_KIND = 5;
    public static final int SYNTHETIC_CLASS_KIND = 3;
    private final int[] bytecodeVersion;
    private final String[] data1;
    private final String[] data2;
    private final int extraInt;
    private final String extraString;
    private final int kind;
    private final int[] metadataVersion;
    private final String packageName;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0010\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassHeader$Companion;", "", "()V", "CLASS_KIND", "", "COMPATIBLE_BYTECODE_VERSION", "", "getCOMPATIBLE_BYTECODE_VERSION$annotations", "COMPATIBLE_METADATA_VERSION", "FILE_FACADE_KIND", "MULTI_FILE_CLASS_FACADE_KIND", "MULTI_FILE_CLASS_PART_KIND", "SYNTHETIC_CLASS_KIND", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Bytecode version had no significant use in Kotlin metadata and it will be removed in a future version.")
        public static /* synthetic */ void getCOMPATIBLE_BYTECODE_VERSION$annotations() {
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        int[] r5 = JvmMetadataVersion.INSTANCE.toArray();
        COMPATIBLE_METADATA_VERSION = Arrays.copyOf(r5, r5.length);
        COMPATIBLE_BYTECODE_VERSION = new int[]{1, 0, 3};
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use another constructor, which doesn't take bytecodeVersion as a parameter.", replaceWith = @ReplaceWith(expression = "KotlinClassHeader(kind, metadataVersion, data1, data2, extraString, packageName, extraInt)", imports = {}))
    public KotlinClassHeader(Integer r5, int[] r10, int[] r11, String[] r12, String[] r13, String r14, String r15, Integer r16) {
        if (r5 == null) goto L5;
        int r17 = r5.intValue();
    L6:
        this.kind = r17;
        int r18 = 0;
        if (r10 != null) goto L9;
        r10 = new int[0];
    L9:
        this.metadataVersion = r10;
        if (r11 != null) goto L12;
        r11 = new int[0];
    L12:
        this.bytecodeVersion = r11;
        if (r12 != null) goto L15;
        r12 = new String[0];
    L15:
        this.data1 = r12;
        if (r13 != null) goto L18;
        r13 = new String[0];
    L18:
        this.data2 = r13;
        if (r14 != null) goto L21;
        r14 = "";
    L21:
        this.extraString = r14;
        if (r15 != null) goto L24;
        r15 = "";
    L24:
        this.packageName = r15;
        if (r16 == null) goto L27;
        r18 = r16.intValue();
    L27:
        this.extraInt = r18;
        return;
    L5:
        r17 = 1;
        goto L6
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Bytecode version had no significant use in Kotlin metadata and it will be removed in a future version.")
    public static /* synthetic */ void getBytecodeVersion$annotations() {
    }

    public final int[] getBytecodeVersion() {
        return this.bytecodeVersion;
    }

    public final String[] getData1() {
        return this.data1;
    }

    public final String[] getData2() {
        return this.data2;
    }

    public final int getExtraInt() {
        return this.extraInt;
    }

    public final String getExtraString() {
        return this.extraString;
    }

    public final int getKind() {
        return this.kind;
    }

    public final int[] getMetadataVersion() {
        return this.metadataVersion;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public KotlinClassHeader(Integer r10, int[] r11, String[] r12, String[] r13, String r14, String r15, Integer r16) {
        this(r10, r11, null, r12, r13, r14, r15, r16);
    }
}
