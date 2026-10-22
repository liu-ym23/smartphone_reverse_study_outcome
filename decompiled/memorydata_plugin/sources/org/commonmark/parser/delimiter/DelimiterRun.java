package org.commonmark.parser.delimiter;

/* JADX INFO: loaded from: classes7.dex */
public interface DelimiterRun {
    boolean canClose();

    boolean canOpen();

    int length();

    int originalLength();
}
