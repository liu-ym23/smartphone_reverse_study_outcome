package org.apache.commons.io.output;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.io.Writer;

/* JADX INFO: loaded from: classes6.dex */
public class StringBuilderWriter extends Writer implements Serializable {
    private static final long serialVersionUID = -146927496096066153L;
    private final StringBuilder builder;

    public StringBuilderWriter() {
        this.builder = new StringBuilder();
    }

    public StringBuilderWriter(int r2) {
        this.builder = new StringBuilder(r2);
    }

    public StringBuilderWriter(StringBuilder r1) {
        if (r1 != null) goto L6;
        r1 = new StringBuilder();
    L6:
        this.builder = r1;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char r2) {
        this.builder.append(r2);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.builder.append(r4);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence r3, int r4, int r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.builder.append(r6, r4, r5);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(char r1) {
        return append(r1);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* synthetic */ Appendable append(CharSequence r3) {
        return append((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* synthetic */ Appendable append(CharSequence r3, int r4, int r5) {
        return append((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    public StringBuilder getBuilder() {
        return this.builder;
    }

    public String toString() {
        return this.builder.toString();
    }

    @Override // java.io.Writer
    public void write(String r1) {
        if (r1 == null) goto L5;
        this.builder.append(r1);
        return;
    }

    @Override // java.io.Writer
    public void write(char[] r1, int r2, int r3) {
        if (r1 == null) goto L5;
        this.builder.append(r1, r2, r3);
        return;
    }
}
