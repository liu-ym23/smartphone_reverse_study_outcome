package com.google.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface MethodOrBuilder extends MessageOrBuilder {
    @Deprecated
    String getEdition();

    @Deprecated
    ByteString getEditionBytes();

    String getName();

    ByteString getNameBytes();

    Option getOptions(int r8);

    int getOptionsCount();

    List<Option> getOptionsList();

    OptionOrBuilder getOptionsOrBuilder(int r8);

    List<? extends OptionOrBuilder> getOptionsOrBuilderList();

    boolean getRequestStreaming();

    String getRequestTypeUrl();

    ByteString getRequestTypeUrlBytes();

    boolean getResponseStreaming();

    String getResponseTypeUrl();

    ByteString getResponseTypeUrlBytes();

    @Deprecated
    Syntax getSyntax();

    @Deprecated
    int getSyntaxValue();
}
