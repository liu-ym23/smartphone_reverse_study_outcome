package com.google.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ApiOrBuilder extends MessageOrBuilder {
    String getEdition();

    ByteString getEditionBytes();

    Method getMethods(int r8);

    int getMethodsCount();

    List<Method> getMethodsList();

    MethodOrBuilder getMethodsOrBuilder(int r8);

    List<? extends MethodOrBuilder> getMethodsOrBuilderList();

    Mixin getMixins(int r8);

    int getMixinsCount();

    List<Mixin> getMixinsList();

    MixinOrBuilder getMixinsOrBuilder(int r8);

    List<? extends MixinOrBuilder> getMixinsOrBuilderList();

    String getName();

    ByteString getNameBytes();

    Option getOptions(int r8);

    int getOptionsCount();

    List<Option> getOptionsList();

    OptionOrBuilder getOptionsOrBuilder(int r8);

    List<? extends OptionOrBuilder> getOptionsOrBuilderList();

    SourceContext getSourceContext();

    SourceContextOrBuilder getSourceContextOrBuilder();

    Syntax getSyntax();

    int getSyntaxValue();

    String getVersion();

    ByteString getVersionBytes();

    boolean hasSourceContext();
}
