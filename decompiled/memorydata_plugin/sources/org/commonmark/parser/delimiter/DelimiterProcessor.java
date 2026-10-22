package org.commonmark.parser.delimiter;

import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes7.dex */
public interface DelimiterProcessor {
    char getClosingCharacter();

    int getDelimiterUse(DelimiterRun r1, DelimiterRun r2);

    int getMinLength();

    char getOpeningCharacter();

    void process(Text r1, Text r2, int r3);
}
