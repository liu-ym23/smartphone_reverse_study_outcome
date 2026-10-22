package com.larus.bmhome.view.resourcebar.bean;

import com.larus.bmhome.instruction.handler.InstructionHandlerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/view/resourcebar/bean/ResourceType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FILE", "IMAGE", InstructionHandlerType.VIDEO, "ADD", "AUDIO", "CUSTOM", InstructionHandlerType.AVATAR, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResourceType extends Enum<ResourceType> {
    public static final ResourceType ADD = null;
    public static final ResourceType AUDIO = null;
    public static final ResourceType AVATAR = null;
    public static final ResourceType CUSTOM = null;
    public static final ResourceType FILE = null;
    public static final ResourceType IMAGE = null;
    public static final ResourceType VIDEO = null;
    public static final /* synthetic */ ResourceType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ResourceType> getEntries() {
        return b;
    }

    static {
        ResourceType r0 = new ResourceType("FILE", 0, 0);
        FILE = r0;
        ResourceType r1 = new ResourceType("IMAGE", 1, 1);
        IMAGE = r1;
        ResourceType r3 = new ResourceType(InstructionHandlerType.VIDEO, 2, 2);
        VIDEO = r3;
        ResourceType r5 = new ResourceType("ADD", 3, 100);
        ADD = r5;
        ResourceType r7 = new ResourceType("AUDIO", 4, 3);
        AUDIO = r7;
        ResourceType r8 = new ResourceType("CUSTOM", 5, 101);
        CUSTOM = r8;
        ResourceType r11 = new ResourceType(InstructionHandlerType.AVATAR, 6, 200);
        AVATAR = r11;
        ResourceType[] r12 = {r0, r1, r3, r5, r7, r8, r11};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static ResourceType[] values() {
        return (ResourceType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ResourceType valueOf(String r1) {
        return (ResourceType) a.a(ResourceType.class, r1);
    }

    public ResourceType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
