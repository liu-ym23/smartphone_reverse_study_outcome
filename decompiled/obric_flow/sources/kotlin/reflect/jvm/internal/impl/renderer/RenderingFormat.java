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
        final String r5 = "PLAIN";
        final int r10 = 0;
        PLAIN = new PLAIN(r5, r10);
        final String r11 = "HTML";
        final int r12 = 1;
        HTML = new HTML(r11, r12);
        $VALUES = $values();
    }

    public /* synthetic */ RenderingFormat(String r5, int r10, DefaultConstructorMarker r11) {
        this(r5, r10);
    }

    public static RenderingFormat valueOf(String r5) {
        return (RenderingFormat) Enum.valueOf(RenderingFormat.class, r5);
    }

    public static RenderingFormat[] values() {
        return (RenderingFormat[]) $VALUES.clone();
    }

    public abstract String escape(String r5);

    private RenderingFormat(String r5, int r10) {
        super(r5, r10);
    }
}
