package hb;

import com.obric.cae.smartNetwork.AppQoEManager.AIMediaEventSchema;

/* JADX INFO: loaded from: classes2.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ b[] f8019b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8020a;

    static {
        f8019b = new b[]{new b("BACKGROUND_COLOR", 0, "backgroundColor"), new b("TEXT_COLOR", 1, "textColor"), new b("STROKE_COLOR", 2, "strokeColor"), new b("FILL_COLOR", 3, "fillColor"), new b("WIDTH", 4, AIMediaEventSchema.FIELD_WIDTH), new b("HEIGHT", 5, AIMediaEventSchema.FIELD_HEIGHT)};
    }

    public b(String r8, int r10, String r11) {
        super(r8, r10);
        this.f8020a = r11;
    }

    public static b valueOf(String r8) {
        return (b) Enum.valueOf(b.class, r8);
    }

    public static b[] values() {
        return (b[]) f8019b.clone();
    }
}
