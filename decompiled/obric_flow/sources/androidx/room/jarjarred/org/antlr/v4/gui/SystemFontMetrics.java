package androidx.room.jarjarred.org.antlr.v4.gui;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.image.BufferedImage;

/* JADX INFO: loaded from: classes.dex */
public class SystemFontMetrics extends BasicFontMetrics {
    protected final Font font;

    public SystemFontMetrics(String r10) {
        BufferedImage r5 = new BufferedImage(40, 40, 6);
        FontRenderContext r11 = GraphicsEnvironment.getLocalGraphicsEnvironment().createGraphics(r5).getFontRenderContext();
        int r12 = 0;
        this.font = new Font(r10, 0, 1000);
        double r13 = 0.0d;
    L4:
        if (r12 >= 255) goto L6;
        TextLayout r14 = new TextLayout(Character.toString((char) r12), this.font, r11);
        r13 = Math.max(r13, r14.getBounds().getHeight());
        this.widths[r12] = (int) r14.getAdvance();
        r12 = r12 + 1;
        goto L4
    L6:
        this.maxCharHeight = (int) Math.round(r13);
    }

    public Font getFont() {
        return this.font;
    }
}
