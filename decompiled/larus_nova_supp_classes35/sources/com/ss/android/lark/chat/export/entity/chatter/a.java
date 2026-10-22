package com.ss.android.lark.chat.export.entity.chatter;

import com.tencent.qqmusic.third.api.contract.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements IChatterDesc {
    public final /* synthetic */ String a;
    public final /* synthetic */ IChatterDesc.Type b;

    @Override // com.ss.android.lark.chat.export.entity.chatter.IChatterDesc
    public final String getContent() {
        return this.a;
    }

    @Override // com.ss.android.lark.chat.export.entity.chatter.IChatterDesc
    public IChatterDesc.Type getType() {
        return this.b;
    }

    public a(IChatterDesc.Type r2) {
        this.a = BuildConfig.FLAVOR;
        this.b = r2;
    }
}
