package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public abstract enum RenderingFormat extends Enum<RenderingFormat> {
    private static final /* synthetic */ RenderingFormat[] $VALUES = null;
    public static final RenderingFormat HTML = null;
    public static final RenderingFormat PLAIN = null;

    private static final /* synthetic */ RenderingFormat[] $values() {
        return new RenderingFormat[]{PLAIN, HTML};
    }

    static {
        final String r10 = "PLAIN";
        final int r11 = 0;
        PLAIN = new PLAIN(r10, r11);
        final String r12 = "HTML";
        final int r13 = 1;
        HTML = new HTML(r12, r13);
        $VALUES = $values();
    }

    private RenderingFormat(String r10, int r11) {
        super(r10, r11);
    }

    public /* synthetic */ RenderingFormat(String r10, int r11, DefaultConstructorMarker r12) {
        this(r10, r11);
    }

    public static RenderingFormat valueOf(String r10) {
        return (RenderingFormat) Enum.valueOf(RenderingFormat.class, r10);
    }

    public static RenderingFormat[] values() {
        return (RenderingFormat[]) $VALUES.clone();
    }

    public abstract String escape(String r10);
}
