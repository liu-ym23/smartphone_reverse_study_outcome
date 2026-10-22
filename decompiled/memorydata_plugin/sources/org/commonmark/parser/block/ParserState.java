package org.commonmark.parser.block;

/* JADX INFO: loaded from: classes7.dex */
public interface ParserState {
    BlockParser getActiveBlockParser();

    int getColumn();

    int getIndent();

    int getIndex();

    CharSequence getLine();

    int getNextNonSpaceIndex();

    boolean isBlank();
}
