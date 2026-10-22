package org.apache.poi.xslf.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.message.StructuredDataId;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class PPTX2PNG {
    private static final Pattern INPUT_PATTERN = null;
    private static final c LOG = null;
    private Charset charset;
    private FileMagic defaultFileType;
    private File dumpfile;
    private boolean emfHeaderBounds;
    private boolean extractEmbedded;
    private File file;
    private String fixSide;
    private String fontDir;
    private String fontMap;
    private String fontTtf;
    private String format;
    private boolean ignoreParse;
    private String outPattern;
    private File outdir;
    private String outfile;
    private boolean quiet;
    private float scale;
    private String slidenumStr;
    private boolean textAsShapes;

    static class NoScratchpadException extends IOException {
        NoScratchpadException() {
        }

        NoScratchpadException(Throwable r1) {
            super(r1);
        }
    }

    static {
        LOG = b.a(PPTX2PNG.class);
        INPUT_PATTERN = Pattern.compile("(?<slideno>[^|]+)\\|(?<format>[^|]+)\\|(?<basename>.+)\\.(?<ext>[^.]++)");
    }

    private PPTX2PNG() {
        this.slidenumStr = StructuredDataId.RESERVED;
        this.scale = 1.0f;
        this.file = null;
        this.format = "png";
        this.outdir = null;
        this.outfile = null;
        this.quiet = false;
        this.outPattern = "${basename}-${slideno}.${format}";
        this.dumpfile = null;
        this.fixSide = "scale";
        this.ignoreParse = false;
        this.extractEmbedded = false;
        this.defaultFileType = FileMagic.OLE2;
        this.textAsShapes = false;
        this.charset = LocaleUtil.CHARSET_1252;
        this.emfHeaderBounds = false;
        this.fontDir = null;
        this.fontTtf = null;
        this.fontMap = null;
    }
}
