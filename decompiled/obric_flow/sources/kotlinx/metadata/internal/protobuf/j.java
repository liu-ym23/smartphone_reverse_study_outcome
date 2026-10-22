package kotlinx.metadata.internal.protobuf;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f19176a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f19177b = null;

    static {
        int[] r5 = new int[WireFormat$FieldType.values().length];
        f19177b = r5;
        r5[WireFormat$FieldType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L40
    L81:
        f19177b[WireFormat$FieldType.FLOAT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L41
    L97:
        f19177b[WireFormat$FieldType.INT64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L42
    L105:
        f19177b[WireFormat$FieldType.UINT64.ordinal()] = 4;     // Catch: NoSuchFieldError -> L43
    L109:
        f19177b[WireFormat$FieldType.INT32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L44
    L69:
        f19177b[WireFormat$FieldType.FIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L45
    L71:
        f19177b[WireFormat$FieldType.FIXED32.ordinal()] = 7;     // Catch: NoSuchFieldError -> L46
    L89:
        f19177b[WireFormat$FieldType.BOOL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L47
    L91:
        f19177b[WireFormat$FieldType.STRING.ordinal()] = 9;     // Catch: NoSuchFieldError -> L48
    L111:
        f19177b[WireFormat$FieldType.BYTES.ordinal()] = 10;     // Catch: NoSuchFieldError -> L49
    L115:
        f19177b[WireFormat$FieldType.UINT32.ordinal()] = 11;     // Catch: NoSuchFieldError -> L50
    L73:
        f19177b[WireFormat$FieldType.SFIXED32.ordinal()] = 12;     // Catch: NoSuchFieldError -> L51
    L79:
        f19177b[WireFormat$FieldType.SFIXED64.ordinal()] = 13;     // Catch: NoSuchFieldError -> L52
    L95:
        f19177b[WireFormat$FieldType.SINT32.ordinal()] = 14;     // Catch: NoSuchFieldError -> L53
    L101:
        f19177b[WireFormat$FieldType.SINT64.ordinal()] = 15;     // Catch: NoSuchFieldError -> L54
    L119:
        f19177b[WireFormat$FieldType.GROUP.ordinal()] = 16;     // Catch: NoSuchFieldError -> L55
    L67:
        f19177b[WireFormat$FieldType.MESSAGE.ordinal()] = 17;     // Catch: NoSuchFieldError -> L56
    L83:
        f19177b[WireFormat$FieldType.ENUM.ordinal()] = 18;     // Catch: NoSuchFieldError -> L57
    L29:
        int[] r10 = new int[WireFormat$JavaType.values().length];
        f19176a = r10;
        r10[WireFormat$JavaType.INT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L58
    L103:
        f19176a[WireFormat$JavaType.LONG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L59
    L107:
        f19176a[WireFormat$JavaType.FLOAT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L60
    L117:
        f19176a[WireFormat$JavaType.DOUBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L61
    L75:
        f19176a[WireFormat$JavaType.BOOLEAN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L62
    L85:
        f19176a[WireFormat$JavaType.STRING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L63
    L87:
        f19176a[WireFormat$JavaType.BYTE_STRING.ordinal()] = 7;     // Catch: NoSuchFieldError -> L64
    L93:
        f19176a[WireFormat$JavaType.ENUM.ordinal()] = 8;     // Catch: NoSuchFieldError -> L65
    L113:
        f19176a[WireFormat$JavaType.MESSAGE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L66
        return;
    }
}
