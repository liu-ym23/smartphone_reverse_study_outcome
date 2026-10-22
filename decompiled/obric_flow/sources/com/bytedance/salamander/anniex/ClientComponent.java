package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/salamander/anniex/ClientComponent;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum ClientComponent extends Enum<ClientComponent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ClientComponent[] f7211a = null;

    static {
        f7211a = new ClientComponent[]{new ClientComponent("View", 0, 0), new ClientComponent("Activity", 1, 1), new ClientComponent("DialogFragment", 2, 2), new ClientComponent("Fragment", 3, 3)};
    }

    public ClientComponent(String r5, int r10, long r11) {
        super(r5, r10);
    }

    public static ClientComponent valueOf(String r5) {
        return (ClientComponent) Enum.valueOf(ClientComponent.class, r5);
    }

    public static ClientComponent[] values() {
        return (ClientComponent[]) f7211a.clone();
    }
}
