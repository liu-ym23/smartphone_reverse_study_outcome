package com.obric.memorydata.ability.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/ability/data/TemperatureStateStandardData;", "Lcom/obric/memorydata/ability/data/IStandardData;", "status", "", "<init>", "(I)V", "getStatus", "()I", "getDataId", "getDataVersion", "Companion", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class s implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8348a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8349b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/ability/data/TemperatureStateStandardData$Companion;", "", "<init>", "()V", "DATA_VERSION", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8348a = new a(null);
    }

    public s(int r1) {
        this.f8349b = r1;
    }

    public final int a() {
        return this.f8349b;
    }

    @Override // com.obric.memorydata.ability.data.h
    public int getDataId() {
        return 100000015;
    }
}
