package androidx.room.jarjarred.org.antlr.v4.gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.print.DocFlavor;
import javax.print.PrintException;
import javax.print.SimpleDoc;
import javax.print.StreamPrintService;
import javax.print.StreamPrintServiceFactory;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.swing.JComponent;

/* JADX INFO: loaded from: classes.dex */
public class GraphicsSupport {
    public GraphicsSupport() {
    }

    public static void saveImage(final JComponent r5, String r10) throws IOException, PrintException {
        if (r10.endsWith(".ps") == false) goto L5;
    L11:
        DocFlavor.SERVICE_FORMATTED r11 = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
        StreamPrintServiceFactory[] r12 = StreamPrintServiceFactory.lookupStreamPrintServiceFactories(r11, "application/postscript");
        System.out.println(Arrays.toString(r12));
        if (r12.length <= 0) goto L16;
        FileOutputStream r13 = new FileOutputStream(r10);
        StreamPrintService r14 = r12[0].getPrintService(r13);
        r14.createPrintJob().print(new SimpleDoc(new AnonymousClass1(r5), r11, null), new HashPrintRequestAttributeSet());
        r13.close();
        return;
    L16:
        return;
    L5:
        if (r10.endsWith(".eps") == true) goto L11;
        Rectangle r15 = r5.getBounds();
        BufferedImage r16 = new BufferedImage(r15.width, r15.height, 1);
        Graphics2D r17 = r16.getGraphics();
        r17.setColor(Color.WHITE);
        r17.fill(r15);
        r5.paint(r17);
        String r18 = r10.substring(r10.lastIndexOf(46) + 1);
        if (ImageIO.write(r16, r18, new File(r10)) == true) goto L10;
        System.err.println("Now imager for " + r18);
    L10:
        r17.dispose();
    }
}
