package org.commonmark.ext.gfm.strikethrough;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.strikethrough.internal.StrikethroughDelimiterProcessor;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer$HtmlRendererExtension;
import org.commonmark.renderer.text.TextContentRenderer$TextContentRendererExtension;

/* JADX INFO: loaded from: classes7.dex */
public class StrikethroughExtension implements Parser.ParserExtension, HtmlRenderer$HtmlRendererExtension, TextContentRenderer$TextContentRendererExtension {
    private StrikethroughExtension() {
    }

    public static Extension create() {
        return new StrikethroughExtension();
    }

    @Override // org.commonmark.parser.Parser.ParserExtension
    public void extend(Parser.Builder r1) {
        r1.customDelimiterProcessor(new StrikethroughDelimiterProcessor());
    }
}
