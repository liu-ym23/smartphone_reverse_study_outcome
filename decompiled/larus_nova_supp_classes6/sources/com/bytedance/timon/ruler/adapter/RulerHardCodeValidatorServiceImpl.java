package com.bytedance.timon.ruler.adapter;

import com.bytedance.timon.ruler.adapter.impl.IRulerHardCodeValidatorService;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/timon/ruler/adapter/RulerHardCodeValidatorServiceImpl;", "Lcom/bytedance/timon/ruler/adapter/impl/IRulerHardCodeValidatorService;", "<init>", "()V", "ruler-adapter_release"}, k = 1, mv = {1, 4, 0})
public final class RulerHardCodeValidatorServiceImpl implements IRulerHardCodeValidatorService {
    public final String a;
    public final String b;

    public RulerHardCodeValidatorServiceImpl() {
        this.a = "guard";
        this.b = "guard_fuse";
    }

    @Override // com.bytedance.timon.ruler.adapter.impl.IRulerHardCodeValidatorService
    public final String a() {
        return this.a;
    }

    @Override // com.bytedance.timon.ruler.adapter.impl.IRulerHardCodeValidatorService
    public final String b() {
        return this.b;
    }
}
