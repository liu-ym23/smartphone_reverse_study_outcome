package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultValueBuilder<M extends Message<M, B>, B extends Message.Builder<M, B>> {
    private final B builder;

    public DefaultValueBuilder(B r5) {
        this.builder = r5;
    }

    public DefaultValueBuilder addDefaultSettingGroup(DefaultValueGroup<M, B> r5) {
        r5.addDefaultValues(this.builder);
        return this;
    }

    public M build() {
        return (M) this.builder.build();
    }
}
