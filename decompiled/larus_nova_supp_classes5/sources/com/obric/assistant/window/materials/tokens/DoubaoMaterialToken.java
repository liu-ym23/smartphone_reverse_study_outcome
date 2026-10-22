package com.obric.assistant.window.materials.tokens;

import cia.k;
import cia.l;
import cia.m;
import cia.n;
import cia.o;
import cia.p;
import com.obric.oui.blur.BlurToken;
import com.obric.oui.color.BlendToken;
import com.obric.oui.color.StrokeToken;
import com.obric.oui.color.i0;
import com.obric.oui.fluid.FluidToken;
import com.obric.oui.graphic.BlendMode;
import com.obric.oui.material.c;
import com.obric.oui.shadow.ShadowToken;
import kma.a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\ba\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b\u0019\u0010\u0003\u001a\u0004\b\u001a\u0010\u0016R.\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00130\u001c8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b#\u0010\bR\u001c\u0010$\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0003\u001a\u0004\b&\u0010\bR\u001c\u0010'\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0003\u001a\u0004\b)\u0010\bR\u001c\u0010*\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0003\u001a\u0004\b,\u0010\bR$\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b.\u0010\u0003\u001a\u0004\b/\u0010\u0016R$\u00100\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b1\u0010\u0003\u001a\u0004\b2\u0010\u0016R.\u00103\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00130\u001c8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010\u0003\u001a\u0004\b5\u0010 R\u001c\u00106\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010\u0003\u001a\u0004\b8\u0010\bR\u001c\u00109\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010\u0003\u001a\u0004\b;\u0010\bR\u001c\u0010<\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b=\u0010\u0003\u001a\u0004\b>\u0010\bR\u001c\u0010?\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010\u0003\u001a\u0004\bA\u0010\bR$\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\bC\u0010\u0003\u001a\u0004\bD\u0010\u0016R$\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\bF\u0010\u0003\u001a\u0004\bG\u0010\u0016R.\u0010H\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00130\u001c8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bI\u0010\u0003\u001a\u0004\bJ\u0010 R\u001c\u0010K\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bL\u0010\u0003\u001a\u0004\bM\u0010\bR\u001c\u0010N\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bO\u0010\u0003\u001a\u0004\bP\u0010\bR\u001c\u0010Q\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bR\u0010\u0003\u001a\u0004\bS\u0010\bR\u001c\u0010T\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bU\u0010\u0003\u001a\u0004\bV\u0010\bR$\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\bX\u0010\u0003\u001a\u0004\bY\u0010\u0016R$\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b[\u0010\u0003\u001a\u0004\b\\\u0010\u0016R.\u0010]\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00130\u001c8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b^\u0010\u0003\u001a\u0004\b_\u0010 R\u001c\u0010`\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\ba\u0010\u0003\u001a\u0004\bb\u0010\bR\u001c\u0010c\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bd\u0010\u0003\u001a\u0004\be\u0010\bR\u001c\u0010f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bg\u0010\u0003\u001a\u0004\bh\u0010\bR\u001c\u0010i\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bj\u0010\u0003\u001a\u0004\bk\u0010\bR$\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\bm\u0010\u0003\u001a\u0004\bn\u0010\u0016R$\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\bp\u0010\u0003\u001a\u0004\bq\u0010\u0016R.\u0010r\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00130\u001c8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bs\u0010\u0003\u001a\u0004\bt\u0010 R\u0010\u0010u\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010v\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010w\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010x\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010y\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0018\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0017R.\u0010{\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00130\u001c8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b|\u0010\u0003\u001a\u0004\b}\u0010 ¨\u0006~"}, d2 = {"Lcom/obric/assistant/window/materials/tokens/DoubaoMaterialToken;", "", "<init>", "()V", "Doubao_Bg_Floating_Fluid_Light", "Lcom/obric/oui/material/MaterialConfig;", "getDoubao_Bg_Floating_Fluid_Light$annotations", "getDoubao_Bg_Floating_Fluid_Light", "()Lcom/obric/oui/material/MaterialConfig;", "Doubao_Bg_Floating_Fluid_Dark", "getDoubao_Bg_Floating_Fluid_Dark$annotations", "getDoubao_Bg_Floating_Fluid_Dark", "Doubao_Bg_Floating_Frost_Light", "getDoubao_Bg_Floating_Frost_Light$annotations", "getDoubao_Bg_Floating_Frost_Light", "Doubao_Bg_Floating_Frost_Dark", "getDoubao_Bg_Floating_Frost_Dark$annotations", "getDoubao_Bg_Floating_Frost_Dark", "Doubao_Bg_Floating_Light", "", "getDoubao_Bg_Floating_Light$annotations", "getDoubao_Bg_Floating_Light", "()[Lcom/obric/oui/material/MaterialConfig;", "[Lcom/obric/oui/material/MaterialConfig;", "Doubao_Bg_Floating_Dark", "getDoubao_Bg_Floating_Dark$annotations", "getDoubao_Bg_Floating_Dark", "Doubao_Bg_Floating", "Lkotlin/Function1;", "", "getDoubao_Bg_Floating$annotations", "getDoubao_Bg_Floating", "()Lkotlin/jvm/functions/Function1;", "Doubao_Bg_Chip_Fluid_Light", "getDoubao_Bg_Chip_Fluid_Light$annotations", "getDoubao_Bg_Chip_Fluid_Light", "Doubao_Bg_Chip_Fluid_Dark", "getDoubao_Bg_Chip_Fluid_Dark$annotations", "getDoubao_Bg_Chip_Fluid_Dark", "Doubao_Bg_Chip_Frost_Light", "getDoubao_Bg_Chip_Frost_Light$annotations", "getDoubao_Bg_Chip_Frost_Light", "Doubao_Bg_Chip_Frost_Dark", "getDoubao_Bg_Chip_Frost_Dark$annotations", "getDoubao_Bg_Chip_Frost_Dark", "Doubao_Bg_Chip_Light", "getDoubao_Bg_Chip_Light$annotations", "getDoubao_Bg_Chip_Light", "Doubao_Bg_Chip_Dark", "getDoubao_Bg_Chip_Dark$annotations", "getDoubao_Bg_Chip_Dark", "Doubao_Bg_Chip", "getDoubao_Bg_Chip$annotations", "getDoubao_Bg_Chip", "Doubao_Bg_Task_Skill_Chip_Fluid_Light", "getDoubao_Bg_Task_Skill_Chip_Fluid_Light$annotations", "getDoubao_Bg_Task_Skill_Chip_Fluid_Light", "Doubao_Bg_Task_Skill_Chip_Fluid_Dark", "getDoubao_Bg_Task_Skill_Chip_Fluid_Dark$annotations", "getDoubao_Bg_Task_Skill_Chip_Fluid_Dark", "Doubao_Bg_Task_Skill_Chip_Frost_Light", "getDoubao_Bg_Task_Skill_Chip_Frost_Light$annotations", "getDoubao_Bg_Task_Skill_Chip_Frost_Light", "Doubao_Bg_Task_Skill_Chip_Frost_Dark", "getDoubao_Bg_Task_Skill_Chip_Frost_Dark$annotations", "getDoubao_Bg_Task_Skill_Chip_Frost_Dark", "Doubao_Bg_Task_Skill_Chip_Light", "getDoubao_Bg_Task_Skill_Chip_Light$annotations", "getDoubao_Bg_Task_Skill_Chip_Light", "Doubao_Bg_Task_Skill_Chip_Dark", "getDoubao_Bg_Task_Skill_Chip_Dark$annotations", "getDoubao_Bg_Task_Skill_Chip_Dark", "Doubao_Bg_Task_Skill_Chip", "getDoubao_Bg_Task_Skill_Chip$annotations", "getDoubao_Bg_Task_Skill_Chip", "Doubao_Bg_Chip_Selected_Fluid_Light", "getDoubao_Bg_Chip_Selected_Fluid_Light$annotations", "getDoubao_Bg_Chip_Selected_Fluid_Light", "Doubao_Bg_Chip_Selected_Fluid_Dark", "getDoubao_Bg_Chip_Selected_Fluid_Dark$annotations", "getDoubao_Bg_Chip_Selected_Fluid_Dark", "Doubao_Bg_Chip_Selected_Frost_Light", "getDoubao_Bg_Chip_Selected_Frost_Light$annotations", "getDoubao_Bg_Chip_Selected_Frost_Light", "Doubao_Bg_Chip_Selected_Frost_Dark", "getDoubao_Bg_Chip_Selected_Frost_Dark$annotations", "getDoubao_Bg_Chip_Selected_Frost_Dark", "Doubao_Bg_Chip_Selected_Light", "getDoubao_Bg_Chip_Selected_Light$annotations", "getDoubao_Bg_Chip_Selected_Light", "Doubao_Bg_Chip_Selected_Dark", "getDoubao_Bg_Chip_Selected_Dark$annotations", "getDoubao_Bg_Chip_Selected_Dark", "Doubao_Bg_Chip_Selected", "getDoubao_Bg_Chip_Selected$annotations", "getDoubao_Bg_Chip_Selected", "Doubao_Bg_Task_Skill_Chip_Selected_Fluid_Light", "getDoubao_Bg_Task_Skill_Chip_Selected_Fluid_Light$annotations", "getDoubao_Bg_Task_Skill_Chip_Selected_Fluid_Light", "Doubao_Bg_Task_Skill_Chip_Selected_Fluid_Dark", "getDoubao_Bg_Task_Skill_Chip_Selected_Fluid_Dark$annotations", "getDoubao_Bg_Task_Skill_Chip_Selected_Fluid_Dark", "Doubao_Bg_Task_Skill_Chip_Selected_Frost_Light", "getDoubao_Bg_Task_Skill_Chip_Selected_Frost_Light$annotations", "getDoubao_Bg_Task_Skill_Chip_Selected_Frost_Light", "Doubao_Bg_Task_Skill_Chip_Selected_Frost_Dark", "getDoubao_Bg_Task_Skill_Chip_Selected_Frost_Dark$annotations", "getDoubao_Bg_Task_Skill_Chip_Selected_Frost_Dark", "Doubao_Bg_Task_Skill_Chip_Selected_Light", "getDoubao_Bg_Task_Skill_Chip_Selected_Light$annotations", "getDoubao_Bg_Task_Skill_Chip_Selected_Light", "Doubao_Bg_Task_Skill_Chip_Selected_Dark", "getDoubao_Bg_Task_Skill_Chip_Selected_Dark$annotations", "getDoubao_Bg_Task_Skill_Chip_Selected_Dark", "Doubao_Bg_Task_Skill_Chip_Selected", "getDoubao_Bg_Task_Skill_Chip_Selected$annotations", "getDoubao_Bg_Task_Skill_Chip_Selected", "Doubao_Bg_Modal_Frost_Light", "Doubao_Bg_Modal_Frost_Dark", "Doubao_Bg_Modal_Fluid_Light", "Doubao_Bg_Modal_Fluid_Dark", "Doubao_Bg_Modal_Light", "Doubao_Bg_Modal_Dark", "Doubao_Bg_Modal", "getDoubao_Bg_Modal$annotations", "getDoubao_Bg_Modal", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoMaterialToken {
    private static final Function1<Boolean, c[]> Doubao_Bg_Chip = null;
    private static final c[] Doubao_Bg_Chip_Dark = null;
    private static final c Doubao_Bg_Chip_Fluid_Dark = null;
    private static final c Doubao_Bg_Chip_Fluid_Light = null;
    private static final c Doubao_Bg_Chip_Frost_Dark = null;
    private static final c Doubao_Bg_Chip_Frost_Light = null;
    private static final c[] Doubao_Bg_Chip_Light = null;
    private static final Function1<Boolean, c[]> Doubao_Bg_Chip_Selected = null;
    private static final c[] Doubao_Bg_Chip_Selected_Dark = null;
    private static final c Doubao_Bg_Chip_Selected_Fluid_Dark = null;
    private static final c Doubao_Bg_Chip_Selected_Fluid_Light = null;
    private static final c Doubao_Bg_Chip_Selected_Frost_Dark = null;
    private static final c Doubao_Bg_Chip_Selected_Frost_Light = null;
    private static final c[] Doubao_Bg_Chip_Selected_Light = null;
    private static final Function1<Boolean, c[]> Doubao_Bg_Floating = null;
    private static final c[] Doubao_Bg_Floating_Dark = null;
    private static final c Doubao_Bg_Floating_Fluid_Dark = null;
    private static final c Doubao_Bg_Floating_Fluid_Light = null;
    private static final c Doubao_Bg_Floating_Frost_Dark = null;
    private static final c Doubao_Bg_Floating_Frost_Light = null;
    private static final c[] Doubao_Bg_Floating_Light = null;
    private static final Function1<Boolean, c[]> Doubao_Bg_Modal = null;
    public static final c[] Doubao_Bg_Modal_Dark = null;
    public static final c Doubao_Bg_Modal_Fluid_Dark = null;
    public static final c Doubao_Bg_Modal_Fluid_Light = null;
    public static final c Doubao_Bg_Modal_Frost_Dark = null;
    public static final c Doubao_Bg_Modal_Frost_Light = null;
    public static final c[] Doubao_Bg_Modal_Light = null;
    private static final Function1<Boolean, c[]> Doubao_Bg_Task_Skill_Chip = null;
    private static final c[] Doubao_Bg_Task_Skill_Chip_Dark = null;
    private static final c Doubao_Bg_Task_Skill_Chip_Fluid_Dark = null;
    private static final c Doubao_Bg_Task_Skill_Chip_Fluid_Light = null;
    private static final c Doubao_Bg_Task_Skill_Chip_Frost_Dark = null;
    private static final c Doubao_Bg_Task_Skill_Chip_Frost_Light = null;
    private static final c[] Doubao_Bg_Task_Skill_Chip_Light = null;
    private static final Function1<Boolean, c[]> Doubao_Bg_Task_Skill_Chip_Selected = null;
    private static final c[] Doubao_Bg_Task_Skill_Chip_Selected_Dark = null;
    private static final c Doubao_Bg_Task_Skill_Chip_Selected_Fluid_Dark = null;
    private static final c Doubao_Bg_Task_Skill_Chip_Selected_Fluid_Light = null;
    private static final c Doubao_Bg_Task_Skill_Chip_Selected_Frost_Dark = null;
    private static final c Doubao_Bg_Task_Skill_Chip_Selected_Frost_Light = null;
    private static final c[] Doubao_Bg_Task_Skill_Chip_Selected_Light = null;
    public static final DoubaoMaterialToken INSTANCE = null;

    private DoubaoMaterialToken() {
    }

    public static /* synthetic */ c[] a(boolean r0) {
        return Doubao_Bg_Floating$lambda$0(r0);
    }

    public static /* synthetic */ c[] b(boolean r0) {
        return Doubao_Bg_Task_Skill_Chip_Selected$lambda$4(r0);
    }

    public static /* synthetic */ c[] c(boolean r0) {
        return Doubao_Bg_Modal$lambda$5(r0);
    }

    public static /* synthetic */ c[] d(boolean r0) {
        return Doubao_Bg_Chip_Selected$lambda$3(r0);
    }

    public static /* synthetic */ c[] e(boolean r0) {
        return Doubao_Bg_Task_Skill_Chip$lambda$2(r0);
    }

    public static /* synthetic */ c[] f(boolean r0) {
        return Doubao_Bg_Chip$lambda$1(r0);
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Chip$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Chip_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Chip_Fluid_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Chip_Fluid_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Chip_Frost_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Chip_Frost_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Chip_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Chip_Selected$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Chip_Selected_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Chip_Selected_Fluid_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Chip_Selected_Fluid_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Chip_Selected_Frost_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Chip_Selected_Frost_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Chip_Selected_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Floating$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Floating_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Floating_Fluid_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Floating_Fluid_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Floating_Frost_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Floating_Frost_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Floating_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Modal$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Task_Skill_Chip$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Task_Skill_Chip_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Task_Skill_Chip_Fluid_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Task_Skill_Chip_Fluid_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Task_Skill_Chip_Frost_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Task_Skill_Chip_Frost_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Task_Skill_Chip_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Task_Skill_Chip_Selected$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Task_Skill_Chip_Selected_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Task_Skill_Chip_Selected_Fluid_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Task_Skill_Chip_Selected_Fluid_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Task_Skill_Chip_Selected_Frost_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Task_Skill_Chip_Selected_Frost_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubao_Bg_Task_Skill_Chip_Selected_Light$annotations() {
    }

    static {
        INSTANCE = new DoubaoMaterialToken();
        int r0 = a.b;
        com.obric.oui.color.a[] r1 = DoubaoBlendToken.getDoubao_Color_Blend_Fluid_Regular_Light();
        BlendMode r2 = BlendMode.SRC_OVER;
        a r8 = a.C0021a.b(r1, new com.obric.oui.color.a(0, r2), null, 58);
        float r3 = BlurToken.Blur_Thin;
        com.obric.oui.fluid.a r4 = FluidToken.OUI_Effect_Fluid_Regular_Light;
        com.obric.oui.shadow.a[] r19 = ShadowToken.Oui_Shadow_Thick;
        c r20 = new c(null, r8, null, null, null, Float.valueOf(r3), r19, r4, 125);
        Doubao_Bg_Floating_Fluid_Light = r20;
        a r11 = a.C0021a.b(DoubaoBlendToken.getDoubao_Color_Blend_Fluid_Regular_Dark(), new com.obric.oui.color.a(0, r2), null, 58);
        com.obric.oui.fluid.a r6 = FluidToken.OUI_Effect_Fluid_Regular_Dark;
        c r7 = new c(null, r11, null, null, null, Float.valueOf(r3), r19, r6, 125);
        Doubao_Bg_Floating_Fluid_Dark = r7;
        a r12 = a.C0021a.b(DoubaoBlendToken.getDoubao_Color_Blend_Frost_Regular_Light(), new com.obric.oui.color.a(0, r2), null, 58);
        i0 r42 = StrokeToken.OUI_Effect_Stroke_Thin_Light;
        c r22 = new c(null, r12, null, r42, null, Float.valueOf(r3), r19, null, 621);
        Doubao_Bg_Floating_Frost_Light = r22;
        a r13 = a.C0021a.b(DoubaoBlendToken.getDoubao_Color_Blend_Frost_Regular_Dark(), new com.obric.oui.color.a(0, r2), null, 58);
        i0 r5 = StrokeToken.OUI_Effect_Stroke_Thin_Dark;
        c r25 = new c(null, r13, null, r5, null, Float.valueOf(r3), r19, null, 621);
        Doubao_Bg_Floating_Frost_Dark = r25;
        Doubao_Bg_Floating_Light = new c[]{r22, r20};
        Doubao_Bg_Floating_Dark = new c[]{r25, r7};
        Doubao_Bg_Floating = new k();
        com.obric.oui.color.a[] r9 = DoubaoBlendToken.getDoubao_Color_Blend_Fluid_Thin_Light();
        com.obric.oui.color.a r14 = BlendToken.OUI_Color_State_Press_Light;
        com.obric.oui.color.a r10 = BlendToken.OUI_Color_State_Active_Light;
        a r23 = a.C0021a.b(r9, r14, r10, 42);
        com.obric.oui.color.a[] r24 = DoubaoBlendToken.getDoubao_Color_Blend_Fluid_Thin_Light();
        com.obric.oui.fluid.a r15 = FluidToken.OUI_Effect_Fluid_Thin_Light;
        com.obric.oui.shadow.a[] r43 = ShadowToken.Oui_Shadow_Regular;
        c r16 = new c(null, r23, r24, null, null, Float.valueOf(r3), r43, r15, 121);
        Doubao_Bg_Chip_Fluid_Light = r16;
        com.obric.oui.color.a[] r17 = DoubaoBlendToken.getDoubao_Color_Blend_Fluid_Thin_Dark();
        com.obric.oui.color.a r18 = BlendToken.OUI_Color_State_Press_Dark;
        com.obric.oui.color.a r21 = BlendToken.OUI_Color_State_Active_Dark;
        a r33 = a.C0021a.b(r17, r18, r21, 42);
        com.obric.oui.fluid.a r110 = FluidToken.OUI_Effect_Fluid_Thin_Dark;
        c r111 = new c(null, r33, null, null, null, Float.valueOf(r3), r43, r110, 125);
        Doubao_Bg_Chip_Fluid_Dark = r111;
        a r34 = a.C0021a.b(DoubaoBlendToken.getDoubao_Color_Blend_Frost_Thin_Light(), r14, r10, 42);
        i0 r26 = StrokeToken.OUI_Effect_Stroke_UltraThin_Light;
        c r112 = new c(null, r34, null, r26, null, Float.valueOf(r3), r43, null, 621);
        Doubao_Bg_Chip_Frost_Light = r112;
        c r27 = new c(null, a.C0021a.b(DoubaoBlendToken.getDoubao_Color_Blend_Frost_Thin_Dark(), r18, r21, 42), null, r5, null, Float.valueOf(r3), r43, null, 621);
        Doubao_Bg_Chip_Frost_Dark = r27;
        Doubao_Bg_Chip_Light = new c[]{r112, r16};
        Doubao_Bg_Chip_Dark = new c[]{r27, r111};
        Doubao_Bg_Chip = new l();
        com.obric.oui.color.a[] r28 = DoubaoBlendToken.getDoubao_Color_Blend_Fluid_Thin_Light();
        com.obric.oui.color.a r113 = com.obric.oui.color.a.c;
        c r29 = new c(null, a.C0021a.b(r28, r113, r10, 42), DoubaoBlendToken.getDoubao_Color_Blend_Fluid_Thin_Light(), null, null, Float.valueOf(r3), r43, r15, 121);
        Doubao_Bg_Task_Skill_Chip_Fluid_Light = r29;
        c r30 = new c(null, a.C0021a.b(DoubaoBlendToken.getDoubao_Color_Blend_Fluid_Thin_Dark(), r113, r21, 42), null, null, null, Float.valueOf(r3), r43, r110, 125);
        Doubao_Bg_Task_Skill_Chip_Fluid_Dark = r30;
        c r31 = new c(null, a.C0021a.b(DoubaoBlendToken.getDoubao_Color_Blend_Frost_Thin_Light(), r113, r10, 42), null, r26, null, Float.valueOf(r3), r43, null, 621);
        Doubao_Bg_Task_Skill_Chip_Frost_Light = r31;
        c r32 = new c(null, a.C0021a.b(DoubaoBlendToken.getDoubao_Color_Blend_Frost_Thin_Dark(), r113, r21, 42), null, r5, null, Float.valueOf(r3), r43, null, 621);
        Doubao_Bg_Task_Skill_Chip_Frost_Dark = r32;
        Doubao_Bg_Task_Skill_Chip_Light = new c[]{r31, r29};
        Doubao_Bg_Task_Skill_Chip_Dark = new c[]{r32, r30};
        Doubao_Bg_Task_Skill_Chip = new m();
        c r35 = new c(null, a.C0021a.b(DoubaoBlendToken.getDoubao_Color_Blend_Fluid_Regular_Light(), r14, null, 58), null, null, null, Float.valueOf(r3), r43, r4, 125);
        Doubao_Bg_Chip_Selected_Fluid_Light = r35;
        c r36 = new c(null, a.C0021a.b(DoubaoBlendToken.getDoubao_Color_Blend_Fluid_Regular_Dark(), r18, null, 58), null, null, null, Float.valueOf(r3), r43, r6, 125);
        Doubao_Bg_Chip_Selected_Fluid_Dark = r36;
        c r37 = new c(null, a.C0021a.b(DoubaoBlendToken.getDoubao_Color_Blend_Frost_Regular_Light(), r14, null, 58), null, r42, null, Float.valueOf(r3), r43, null, 621);
        Doubao_Bg_Chip_Selected_Frost_Light = r37;
        c r38 = new c(null, a.C0021a.b(DoubaoBlendToken.getDoubao_Color_Blend_Frost_Regular_Dark(), r18, null, 58), null, r5, null, Float.valueOf(r3), r43, null, 621);
        Doubao_Bg_Chip_Selected_Frost_Dark = r38;
        Doubao_Bg_Chip_Selected_Light = new c[]{r37, r35};
        Doubao_Bg_Chip_Selected_Dark = new c[]{r38, r36};
        Doubao_Bg_Chip_Selected = new n();
        c r39 = new c(null, a.C0021a.b(DoubaoBlendToken.getDoubao_Color_Blend_Fluid_Regular_Light(), r113, null, 58), null, null, null, Float.valueOf(r3), r43, r4, 125);
        Doubao_Bg_Task_Skill_Chip_Selected_Fluid_Light = r39;
        c r40 = new c(null, a.C0021a.b(DoubaoBlendToken.getDoubao_Color_Blend_Fluid_Regular_Dark(), r113, null, 58), null, null, null, Float.valueOf(r3), r43, r6, 125);
        Doubao_Bg_Task_Skill_Chip_Selected_Fluid_Dark = r40;
        c r41 = new c(null, a.C0021a.b(DoubaoBlendToken.getDoubao_Color_Blend_Frost_Regular_Light(), r113, null, 58), null, r42, null, Float.valueOf(r3), r43, null, 621);
        Doubao_Bg_Task_Skill_Chip_Selected_Frost_Light = r41;
        c r44 = new c(null, a.C0021a.b(DoubaoBlendToken.getDoubao_Color_Blend_Frost_Regular_Dark(), r113, null, 58), null, r5, null, Float.valueOf(r3), r43, null, 621);
        Doubao_Bg_Task_Skill_Chip_Selected_Frost_Dark = r44;
        Doubao_Bg_Task_Skill_Chip_Selected_Light = new c[]{r41, r39};
        Doubao_Bg_Task_Skill_Chip_Selected_Dark = new c[]{r44, r40};
        Doubao_Bg_Task_Skill_Chip_Selected = new o();
        com.obric.oui.color.a[] r114 = DoubaoBlendToken.Doubao_Color_Blend_Frost_Thick_Light;
        float r45 = BlurToken.Blur_Thick;
        c r46 = new c(null, null, r114, null, null, Float.valueOf(r45), null, null, 891);
        Doubao_Bg_Modal_Frost_Light = r46;
        c r47 = new c(null, null, DoubaoBlendToken.Doubao_Color_Blend_Frost_Thick_Dark, null, null, Float.valueOf(r45), null, null, 891);
        Doubao_Bg_Modal_Frost_Dark = r47;
        c r48 = new c(null, null, DoubaoBlendToken.Doubao_Color_Blend_Fluid_Thick_Light, null, null, Float.valueOf(r45), null, r4, 379);
        Doubao_Bg_Modal_Fluid_Light = r48;
        c r49 = new c(null, null, DoubaoBlendToken.Doubao_Color_Blend_Fluid_Thick_Dark, null, null, Float.valueOf(BlurToken.Blur_UltraThick), null, r6, 379);
        Doubao_Bg_Modal_Fluid_Dark = r49;
        Doubao_Bg_Modal_Light = new c[]{r46, r48};
        Doubao_Bg_Modal_Dark = new c[]{r47, r49};
        Doubao_Bg_Modal = new p();
    }

    public static final Function1<Boolean, c[]> getDoubao_Bg_Chip() {
        return Doubao_Bg_Chip;
    }

    public static final c[] getDoubao_Bg_Chip_Dark() {
        return Doubao_Bg_Chip_Dark;
    }

    public static final c getDoubao_Bg_Chip_Fluid_Dark() {
        return Doubao_Bg_Chip_Fluid_Dark;
    }

    public static final c getDoubao_Bg_Chip_Fluid_Light() {
        return Doubao_Bg_Chip_Fluid_Light;
    }

    public static final c getDoubao_Bg_Chip_Frost_Dark() {
        return Doubao_Bg_Chip_Frost_Dark;
    }

    public static final c getDoubao_Bg_Chip_Frost_Light() {
        return Doubao_Bg_Chip_Frost_Light;
    }

    public static final c[] getDoubao_Bg_Chip_Light() {
        return Doubao_Bg_Chip_Light;
    }

    public static final Function1<Boolean, c[]> getDoubao_Bg_Chip_Selected() {
        return Doubao_Bg_Chip_Selected;
    }

    public static final c[] getDoubao_Bg_Chip_Selected_Dark() {
        return Doubao_Bg_Chip_Selected_Dark;
    }

    public static final c getDoubao_Bg_Chip_Selected_Fluid_Dark() {
        return Doubao_Bg_Chip_Selected_Fluid_Dark;
    }

    public static final c getDoubao_Bg_Chip_Selected_Fluid_Light() {
        return Doubao_Bg_Chip_Selected_Fluid_Light;
    }

    public static final c getDoubao_Bg_Chip_Selected_Frost_Dark() {
        return Doubao_Bg_Chip_Selected_Frost_Dark;
    }

    public static final c getDoubao_Bg_Chip_Selected_Frost_Light() {
        return Doubao_Bg_Chip_Selected_Frost_Light;
    }

    public static final c[] getDoubao_Bg_Chip_Selected_Light() {
        return Doubao_Bg_Chip_Selected_Light;
    }

    public static final Function1<Boolean, c[]> getDoubao_Bg_Floating() {
        return Doubao_Bg_Floating;
    }

    public static final c[] getDoubao_Bg_Floating_Dark() {
        return Doubao_Bg_Floating_Dark;
    }

    public static final c getDoubao_Bg_Floating_Fluid_Dark() {
        return Doubao_Bg_Floating_Fluid_Dark;
    }

    public static final c getDoubao_Bg_Floating_Fluid_Light() {
        return Doubao_Bg_Floating_Fluid_Light;
    }

    public static final c getDoubao_Bg_Floating_Frost_Dark() {
        return Doubao_Bg_Floating_Frost_Dark;
    }

    public static final c getDoubao_Bg_Floating_Frost_Light() {
        return Doubao_Bg_Floating_Frost_Light;
    }

    public static final c[] getDoubao_Bg_Floating_Light() {
        return Doubao_Bg_Floating_Light;
    }

    public static final Function1<Boolean, c[]> getDoubao_Bg_Modal() {
        return Doubao_Bg_Modal;
    }

    public static final Function1<Boolean, c[]> getDoubao_Bg_Task_Skill_Chip() {
        return Doubao_Bg_Task_Skill_Chip;
    }

    public static final c[] getDoubao_Bg_Task_Skill_Chip_Dark() {
        return Doubao_Bg_Task_Skill_Chip_Dark;
    }

    public static final c getDoubao_Bg_Task_Skill_Chip_Fluid_Dark() {
        return Doubao_Bg_Task_Skill_Chip_Fluid_Dark;
    }

    public static final c getDoubao_Bg_Task_Skill_Chip_Fluid_Light() {
        return Doubao_Bg_Task_Skill_Chip_Fluid_Light;
    }

    public static final c getDoubao_Bg_Task_Skill_Chip_Frost_Dark() {
        return Doubao_Bg_Task_Skill_Chip_Frost_Dark;
    }

    public static final c getDoubao_Bg_Task_Skill_Chip_Frost_Light() {
        return Doubao_Bg_Task_Skill_Chip_Frost_Light;
    }

    public static final c[] getDoubao_Bg_Task_Skill_Chip_Light() {
        return Doubao_Bg_Task_Skill_Chip_Light;
    }

    public static final Function1<Boolean, c[]> getDoubao_Bg_Task_Skill_Chip_Selected() {
        return Doubao_Bg_Task_Skill_Chip_Selected;
    }

    public static final c[] getDoubao_Bg_Task_Skill_Chip_Selected_Dark() {
        return Doubao_Bg_Task_Skill_Chip_Selected_Dark;
    }

    public static final c getDoubao_Bg_Task_Skill_Chip_Selected_Fluid_Dark() {
        return Doubao_Bg_Task_Skill_Chip_Selected_Fluid_Dark;
    }

    public static final c getDoubao_Bg_Task_Skill_Chip_Selected_Fluid_Light() {
        return Doubao_Bg_Task_Skill_Chip_Selected_Fluid_Light;
    }

    public static final c getDoubao_Bg_Task_Skill_Chip_Selected_Frost_Dark() {
        return Doubao_Bg_Task_Skill_Chip_Selected_Frost_Dark;
    }

    public static final c getDoubao_Bg_Task_Skill_Chip_Selected_Frost_Light() {
        return Doubao_Bg_Task_Skill_Chip_Selected_Frost_Light;
    }

    public static final c[] getDoubao_Bg_Task_Skill_Chip_Selected_Light() {
        return Doubao_Bg_Task_Skill_Chip_Selected_Light;
    }

    private static final c[] Doubao_Bg_Chip$lambda$1(boolean r1) {
        if (r1 == true) goto L10;
        if (r1 == true) goto L9;
        return Doubao_Bg_Chip_Dark;
    L9:
        throw new NoWhenBranchMatchedException();
    L10:
        return Doubao_Bg_Chip_Light;
    }

    private static final c[] Doubao_Bg_Chip_Selected$lambda$3(boolean r1) {
        if (r1 == true) goto L10;
        if (r1 == true) goto L9;
        return Doubao_Bg_Chip_Selected_Dark;
    L9:
        throw new NoWhenBranchMatchedException();
    L10:
        return Doubao_Bg_Chip_Selected_Light;
    }

    private static final c[] Doubao_Bg_Floating$lambda$0(boolean r1) {
        if (r1 == true) goto L10;
        if (r1 == true) goto L9;
        return Doubao_Bg_Floating_Dark;
    L9:
        throw new NoWhenBranchMatchedException();
    L10:
        return Doubao_Bg_Floating_Light;
    }

    private static final c[] Doubao_Bg_Modal$lambda$5(boolean r1) {
        if (r1 == true) goto L10;
        if (r1 == true) goto L9;
        return Doubao_Bg_Modal_Dark;
    L9:
        throw new NoWhenBranchMatchedException();
    L10:
        return Doubao_Bg_Modal_Light;
    }

    private static final c[] Doubao_Bg_Task_Skill_Chip$lambda$2(boolean r1) {
        if (r1 == true) goto L10;
        if (r1 == true) goto L9;
        return Doubao_Bg_Task_Skill_Chip_Dark;
    L9:
        throw new NoWhenBranchMatchedException();
    L10:
        return Doubao_Bg_Task_Skill_Chip_Light;
    }

    private static final c[] Doubao_Bg_Task_Skill_Chip_Selected$lambda$4(boolean r1) {
        if (r1 == true) goto L10;
        if (r1 == true) goto L9;
        return Doubao_Bg_Task_Skill_Chip_Selected_Dark;
    L9:
        throw new NoWhenBranchMatchedException();
    L10:
        return Doubao_Bg_Task_Skill_Chip_Selected_Light;
    }
}
