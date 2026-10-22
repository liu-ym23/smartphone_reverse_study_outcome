package com.obric.assistant.window.materials.tokens;

import cia.q;
import cia.r;
import cia.s;
import cia.t;
import cia.u;
import cia.v;
import com.obric.cae.libs.useraware.ApWakeEvent;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\ba\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b\u0019\u0010\u0003\u001a\u0004\b\u001a\u0010\u0016R.\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00130\u001c8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b#\u0010\bR\u001c\u0010$\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0003\u001a\u0004\b&\u0010\bR\u001c\u0010'\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0003\u001a\u0004\b)\u0010\bR\u001c\u0010*\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0003\u001a\u0004\b,\u0010\bR$\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b.\u0010\u0003\u001a\u0004\b/\u0010\u0016R$\u00100\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b1\u0010\u0003\u001a\u0004\b2\u0010\u0016R.\u00103\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00130\u001c8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010\u0003\u001a\u0004\b5\u0010 R\u001c\u00106\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010\u0003\u001a\u0004\b8\u0010\bR\u001c\u00109\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010\u0003\u001a\u0004\b;\u0010\bR\u001c\u0010<\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b=\u0010\u0003\u001a\u0004\b>\u0010\bR\u001c\u0010?\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010\u0003\u001a\u0004\bA\u0010\bR$\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\bC\u0010\u0003\u001a\u0004\bD\u0010\u0016R$\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\bF\u0010\u0003\u001a\u0004\bG\u0010\u0016R.\u0010H\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00130\u001c8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bI\u0010\u0003\u001a\u0004\bJ\u0010 R\u001c\u0010K\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bL\u0010\u0003\u001a\u0004\bM\u0010\bR\u001c\u0010N\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bO\u0010\u0003\u001a\u0004\bP\u0010\bR\u001c\u0010Q\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bR\u0010\u0003\u001a\u0004\bS\u0010\bR\u001c\u0010T\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bU\u0010\u0003\u001a\u0004\bV\u0010\bR$\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\bX\u0010\u0003\u001a\u0004\bY\u0010\u0016R$\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b[\u0010\u0003\u001a\u0004\b\\\u0010\u0016R.\u0010]\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00130\u001c8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b^\u0010\u0003\u001a\u0004\b_\u0010 R\u001c\u0010`\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\ba\u0010\u0003\u001a\u0004\bb\u0010\bR\u001c\u0010c\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bd\u0010\u0003\u001a\u0004\be\u0010\bR\u001c\u0010f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bg\u0010\u0003\u001a\u0004\bh\u0010\bR\u001c\u0010i\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bj\u0010\u0003\u001a\u0004\bk\u0010\bR$\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\bm\u0010\u0003\u001a\u0004\bn\u0010\u0016R$\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\bp\u0010\u0003\u001a\u0004\bq\u0010\u0016R.\u0010r\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00130\u001c8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bs\u0010\u0003\u001a\u0004\bt\u0010 R\u0010\u0010u\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010v\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010w\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010x\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010y\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0018\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0017R.\u0010{\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00130\u001c8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b|\u0010\u0003\u001a\u0004\b}\u0010 ¨\u0006~"}, d2 = {"Lcom/obric/assistant/window/materials/tokens/DoubaoMaterialTokenV2;", "", "<init>", "()V", "DoubaoV2_Bg_Floating_Fluid_Light", "Lcom/obric/oui/material/MaterialConfig;", "getDoubaoV2_Bg_Floating_Fluid_Light$annotations", "getDoubaoV2_Bg_Floating_Fluid_Light", "()Lcom/obric/oui/material/MaterialConfig;", "DoubaoV2_Bg_Floating_Fluid_Dark", "getDoubaoV2_Bg_Floating_Fluid_Dark$annotations", "getDoubaoV2_Bg_Floating_Fluid_Dark", "DoubaoV2_Bg_Floating_Frost_Light", "getDoubaoV2_Bg_Floating_Frost_Light$annotations", "getDoubaoV2_Bg_Floating_Frost_Light", "DoubaoV2_Bg_Floating_Frost_Dark", "getDoubaoV2_Bg_Floating_Frost_Dark$annotations", "getDoubaoV2_Bg_Floating_Frost_Dark", "DoubaoV2_Bg_Floating_Light", "", "getDoubaoV2_Bg_Floating_Light$annotations", "getDoubaoV2_Bg_Floating_Light", "()[Lcom/obric/oui/material/MaterialConfig;", "[Lcom/obric/oui/material/MaterialConfig;", "DoubaoV2_Bg_Floating_Dark", "getDoubaoV2_Bg_Floating_Dark$annotations", "getDoubaoV2_Bg_Floating_Dark", "DoubaoV2_Bg_Floating", "Lkotlin/Function1;", "", "getDoubaoV2_Bg_Floating$annotations", "getDoubaoV2_Bg_Floating", "()Lkotlin/jvm/functions/Function1;", "DoubaoV2_Bg_Chip_Fluid_Light", "getDoubaoV2_Bg_Chip_Fluid_Light$annotations", "getDoubaoV2_Bg_Chip_Fluid_Light", "DoubaoV2_Bg_Chip_Fluid_Dark", "getDoubaoV2_Bg_Chip_Fluid_Dark$annotations", "getDoubaoV2_Bg_Chip_Fluid_Dark", "DoubaoV2_Bg_Chip_Frost_Light", "getDoubaoV2_Bg_Chip_Frost_Light$annotations", "getDoubaoV2_Bg_Chip_Frost_Light", "DoubaoV2_Bg_Chip_Frost_Dark", "getDoubaoV2_Bg_Chip_Frost_Dark$annotations", "getDoubaoV2_Bg_Chip_Frost_Dark", "DoubaoV2_Bg_Chip_Light", "getDoubaoV2_Bg_Chip_Light$annotations", "getDoubaoV2_Bg_Chip_Light", "DoubaoV2_Bg_Chip_Dark", "getDoubaoV2_Bg_Chip_Dark$annotations", "getDoubaoV2_Bg_Chip_Dark", "DoubaoV2_Bg_Chip", "getDoubaoV2_Bg_Chip$annotations", "getDoubaoV2_Bg_Chip", "DoubaoV2_Bg_Task_Skill_Chip_Fluid_Light", "getDoubaoV2_Bg_Task_Skill_Chip_Fluid_Light$annotations", "getDoubaoV2_Bg_Task_Skill_Chip_Fluid_Light", "DoubaoV2_Bg_Task_Skill_Chip_Fluid_Dark", "getDoubaoV2_Bg_Task_Skill_Chip_Fluid_Dark$annotations", "getDoubaoV2_Bg_Task_Skill_Chip_Fluid_Dark", "DoubaoV2_Bg_Task_Skill_Chip_Frost_Light", "getDoubaoV2_Bg_Task_Skill_Chip_Frost_Light$annotations", "getDoubaoV2_Bg_Task_Skill_Chip_Frost_Light", "DoubaoV2_Bg_Task_Skill_Chip_Frost_Dark", "getDoubaoV2_Bg_Task_Skill_Chip_Frost_Dark$annotations", "getDoubaoV2_Bg_Task_Skill_Chip_Frost_Dark", "DoubaoV2_Bg_Task_Skill_Chip_Light", "getDoubaoV2_Bg_Task_Skill_Chip_Light$annotations", "getDoubaoV2_Bg_Task_Skill_Chip_Light", "DoubaoV2_Bg_Task_Skill_Chip_Dark", "getDoubaoV2_Bg_Task_Skill_Chip_Dark$annotations", "getDoubaoV2_Bg_Task_Skill_Chip_Dark", "DoubaoV2_Bg_Task_Skill_Chip", "getDoubaoV2_Bg_Task_Skill_Chip$annotations", "getDoubaoV2_Bg_Task_Skill_Chip", "DoubaoV2_Bg_Chip_Selected_Fluid_Light", "getDoubaoV2_Bg_Chip_Selected_Fluid_Light$annotations", "getDoubaoV2_Bg_Chip_Selected_Fluid_Light", "DoubaoV2_Bg_Chip_Selected_Fluid_Dark", "getDoubaoV2_Bg_Chip_Selected_Fluid_Dark$annotations", "getDoubaoV2_Bg_Chip_Selected_Fluid_Dark", "DoubaoV2_Bg_Chip_Selected_Frost_Light", "getDoubaoV2_Bg_Chip_Selected_Frost_Light$annotations", "getDoubaoV2_Bg_Chip_Selected_Frost_Light", "DoubaoV2_Bg_Chip_Selected_Frost_Dark", "getDoubaoV2_Bg_Chip_Selected_Frost_Dark$annotations", "getDoubaoV2_Bg_Chip_Selected_Frost_Dark", "DoubaoV2_Bg_Chip_Selected_Light", "getDoubaoV2_Bg_Chip_Selected_Light$annotations", "getDoubaoV2_Bg_Chip_Selected_Light", "DoubaoV2_Bg_Chip_Selected_Dark", "getDoubaoV2_Bg_Chip_Selected_Dark$annotations", "getDoubaoV2_Bg_Chip_Selected_Dark", "DoubaoV2_Bg_Chip_Selected", "getDoubaoV2_Bg_Chip_Selected$annotations", "getDoubaoV2_Bg_Chip_Selected", "DoubaoV2_Bg_Task_Skill_Chip_Selected_Fluid_Light", "getDoubaoV2_Bg_Task_Skill_Chip_Selected_Fluid_Light$annotations", "getDoubaoV2_Bg_Task_Skill_Chip_Selected_Fluid_Light", "DoubaoV2_Bg_Task_Skill_Chip_Selected_Fluid_Dark", "getDoubaoV2_Bg_Task_Skill_Chip_Selected_Fluid_Dark$annotations", "getDoubaoV2_Bg_Task_Skill_Chip_Selected_Fluid_Dark", "DoubaoV2_Bg_Task_Skill_Chip_Selected_Frost_Light", "getDoubaoV2_Bg_Task_Skill_Chip_Selected_Frost_Light$annotations", "getDoubaoV2_Bg_Task_Skill_Chip_Selected_Frost_Light", "DoubaoV2_Bg_Task_Skill_Chip_Selected_Frost_Dark", "getDoubaoV2_Bg_Task_Skill_Chip_Selected_Frost_Dark$annotations", "getDoubaoV2_Bg_Task_Skill_Chip_Selected_Frost_Dark", "DoubaoV2_Bg_Task_Skill_Chip_Selected_Light", "getDoubaoV2_Bg_Task_Skill_Chip_Selected_Light$annotations", "getDoubaoV2_Bg_Task_Skill_Chip_Selected_Light", "DoubaoV2_Bg_Task_Skill_Chip_Selected_Dark", "getDoubaoV2_Bg_Task_Skill_Chip_Selected_Dark$annotations", "getDoubaoV2_Bg_Task_Skill_Chip_Selected_Dark", "DoubaoV2_Bg_Task_Skill_Chip_Selected", "getDoubaoV2_Bg_Task_Skill_Chip_Selected$annotations", "getDoubaoV2_Bg_Task_Skill_Chip_Selected", "DoubaoV2_Bg_Modal_Frost_Light", "DoubaoV2_Bg_Modal_Frost_Dark", "DoubaoV2_Bg_Modal_Fluid_Light", "DoubaoV2_Bg_Modal_Fluid_Dark", "DoubaoV2_Bg_Modal_Light", "DoubaoV2_Bg_Modal_Dark", "DoubaoV2_Bg_Modal", "getDoubaoV2_Bg_Modal$annotations", "getDoubaoV2_Bg_Modal", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoMaterialTokenV2 {
    private static final Function1<Boolean, c[]> DoubaoV2_Bg_Chip = null;
    private static final c[] DoubaoV2_Bg_Chip_Dark = null;
    private static final c DoubaoV2_Bg_Chip_Fluid_Dark = null;
    private static final c DoubaoV2_Bg_Chip_Fluid_Light = null;
    private static final c DoubaoV2_Bg_Chip_Frost_Dark = null;
    private static final c DoubaoV2_Bg_Chip_Frost_Light = null;
    private static final c[] DoubaoV2_Bg_Chip_Light = null;
    private static final Function1<Boolean, c[]> DoubaoV2_Bg_Chip_Selected = null;
    private static final c[] DoubaoV2_Bg_Chip_Selected_Dark = null;
    private static final c DoubaoV2_Bg_Chip_Selected_Fluid_Dark = null;
    private static final c DoubaoV2_Bg_Chip_Selected_Fluid_Light = null;
    private static final c DoubaoV2_Bg_Chip_Selected_Frost_Dark = null;
    private static final c DoubaoV2_Bg_Chip_Selected_Frost_Light = null;
    private static final c[] DoubaoV2_Bg_Chip_Selected_Light = null;
    private static final Function1<Boolean, c[]> DoubaoV2_Bg_Floating = null;
    private static final c[] DoubaoV2_Bg_Floating_Dark = null;
    private static final c DoubaoV2_Bg_Floating_Fluid_Dark = null;
    private static final c DoubaoV2_Bg_Floating_Fluid_Light = null;
    private static final c DoubaoV2_Bg_Floating_Frost_Dark = null;
    private static final c DoubaoV2_Bg_Floating_Frost_Light = null;
    private static final c[] DoubaoV2_Bg_Floating_Light = null;
    private static final Function1<Boolean, c[]> DoubaoV2_Bg_Modal = null;
    public static final c[] DoubaoV2_Bg_Modal_Dark = null;
    public static final c DoubaoV2_Bg_Modal_Fluid_Dark = null;
    public static final c DoubaoV2_Bg_Modal_Fluid_Light = null;
    public static final c DoubaoV2_Bg_Modal_Frost_Dark = null;
    public static final c DoubaoV2_Bg_Modal_Frost_Light = null;
    public static final c[] DoubaoV2_Bg_Modal_Light = null;
    private static final Function1<Boolean, c[]> DoubaoV2_Bg_Task_Skill_Chip = null;
    private static final c[] DoubaoV2_Bg_Task_Skill_Chip_Dark = null;
    private static final c DoubaoV2_Bg_Task_Skill_Chip_Fluid_Dark = null;
    private static final c DoubaoV2_Bg_Task_Skill_Chip_Fluid_Light = null;
    private static final c DoubaoV2_Bg_Task_Skill_Chip_Frost_Dark = null;
    private static final c DoubaoV2_Bg_Task_Skill_Chip_Frost_Light = null;
    private static final c[] DoubaoV2_Bg_Task_Skill_Chip_Light = null;
    private static final Function1<Boolean, c[]> DoubaoV2_Bg_Task_Skill_Chip_Selected = null;
    private static final c[] DoubaoV2_Bg_Task_Skill_Chip_Selected_Dark = null;
    private static final c DoubaoV2_Bg_Task_Skill_Chip_Selected_Fluid_Dark = null;
    private static final c DoubaoV2_Bg_Task_Skill_Chip_Selected_Fluid_Light = null;
    private static final c DoubaoV2_Bg_Task_Skill_Chip_Selected_Frost_Dark = null;
    private static final c DoubaoV2_Bg_Task_Skill_Chip_Selected_Frost_Light = null;
    private static final c[] DoubaoV2_Bg_Task_Skill_Chip_Selected_Light = null;
    public static final DoubaoMaterialTokenV2 INSTANCE = null;

    private DoubaoMaterialTokenV2() {
    }

    public static /* synthetic */ c[] a(boolean r0) {
        return DoubaoV2_Bg_Chip_Selected$lambda$3(r0);
    }

    public static /* synthetic */ c[] b(boolean r0) {
        return DoubaoV2_Bg_Task_Skill_Chip_Selected$lambda$4(r0);
    }

    public static /* synthetic */ c[] c(boolean r0) {
        return DoubaoV2_Bg_Modal$lambda$5(r0);
    }

    public static /* synthetic */ c[] d(boolean r0) {
        return DoubaoV2_Bg_Task_Skill_Chip$lambda$2(r0);
    }

    public static /* synthetic */ c[] e(boolean r0) {
        return DoubaoV2_Bg_Floating$lambda$0(r0);
    }

    public static /* synthetic */ c[] f(boolean r0) {
        return DoubaoV2_Bg_Chip$lambda$1(r0);
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Chip$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Chip_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Chip_Fluid_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Chip_Fluid_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Chip_Frost_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Chip_Frost_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Chip_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Chip_Selected$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Chip_Selected_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Chip_Selected_Fluid_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Chip_Selected_Fluid_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Chip_Selected_Frost_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Chip_Selected_Frost_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Chip_Selected_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Floating$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Floating_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Floating_Fluid_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Floating_Fluid_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Floating_Frost_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Floating_Frost_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Floating_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Modal$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Task_Skill_Chip$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Task_Skill_Chip_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Task_Skill_Chip_Fluid_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Task_Skill_Chip_Fluid_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Task_Skill_Chip_Frost_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Task_Skill_Chip_Frost_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Task_Skill_Chip_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Task_Skill_Chip_Selected$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Task_Skill_Chip_Selected_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Task_Skill_Chip_Selected_Fluid_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Task_Skill_Chip_Selected_Fluid_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Task_Skill_Chip_Selected_Frost_Dark$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Task_Skill_Chip_Selected_Frost_Light$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDoubaoV2_Bg_Task_Skill_Chip_Selected_Light$annotations() {
    }

    static {
        INSTANCE = new DoubaoMaterialTokenV2();
        int r0 = a.b;
        com.obric.oui.color.a[] r1 = DoubaoBlendTokenV2.getDoubaoV2_Color_Blend_Fluid_Regular_Light();
        BlendMode r2 = BlendMode.SRC_OVER;
        a r8 = a.a.b(r1, new com.obric.oui.color.a(0, r2), null, 58);
        float r3 = BlurToken.Blur_Thin;
        com.obric.oui.fluid.a r17 = FluidToken.OUI_Effect_Fluid_Regular_Light;
        com.obric.oui.shadow.a[] r4 = ShadowToken.Oui_Shadow_Thick;
        c r16 = new c(null, r8, null, null, null, Float.valueOf(r3), r4, r17, 125);
        DoubaoV2_Bg_Floating_Fluid_Light = r16;
        a r20 = a.a.b(DoubaoBlendTokenV2.getDoubaoV2_Color_Blend_Fluid_Regular_Dark(), new com.obric.oui.color.a(0, r2), null, 58);
        com.obric.oui.fluid.a r28 = FluidToken.OUI_Effect_Fluid_Regular_Dark;
        c r6 = new c(null, r20, null, null, null, Float.valueOf(r3), r4, r28, 125);
        DoubaoV2_Bg_Floating_Fluid_Dark = r6;
        a r21 = a.a.b(DoubaoBlendTokenV2.getDoubaoV2_Color_Blend_Frost_Regular_Light(), new com.obric.oui.color.a(0, r2), null, 58);
        i0 r10 = StrokeToken.OUI_Effect_Stroke_Thin_Light;
        c r11 = new c(null, r21, null, r10, null, Float.valueOf(r3), r4, null, 621);
        DoubaoV2_Bg_Floating_Frost_Light = r11;
        a r22 = a.a.b(DoubaoBlendTokenV2.getDoubaoV2_Color_Blend_Frost_Regular_Dark(), new com.obric.oui.color.a(0, r2), null, 58);
        i0 r5 = StrokeToken.OUI_Effect_Stroke_Thin_Dark;
        c r13 = new c(null, r22, null, r5, null, Float.valueOf(r3), r4, null, 621);
        DoubaoV2_Bg_Floating_Frost_Dark = r13;
        DoubaoV2_Bg_Floating_Light = new c[]{r11, r16};
        DoubaoV2_Bg_Floating_Dark = new c[]{r13, r6};
        DoubaoV2_Bg_Floating = new q();
        com.obric.oui.color.a[] r7 = DoubaoBlendTokenV2.getDoubaoV2_Color_Blend_Fluid_Thin_Light();
        com.obric.oui.color.a r9 = BlendToken.OUI_Color_State_Press_Light;
        com.obric.oui.color.a r12 = BlendToken.OUI_Color_State_Active_Light;
        a r39 = a.a.b(r7, r9, r12, 42);
        com.obric.oui.color.a[] r40 = DoubaoBlendTokenV2.getDoubaoV2_Color_Blend_Fluid_Thin_Light();
        com.obric.oui.fluid.a r49 = FluidToken.OUI_Effect_Fluid_Thin_Light;
        com.obric.oui.shadow.a[] r14 = ShadowToken.Oui_Shadow_Regular;
        c r15 = new c(null, r39, r40, null, null, Float.valueOf(r3), r14, r49, ApWakeEvent.WALKING_END);
        DoubaoV2_Bg_Chip_Fluid_Light = r15;
        com.obric.oui.color.a[] r18 = DoubaoBlendTokenV2.getDoubaoV2_Color_Blend_Fluid_Thin_Dark();
        com.obric.oui.color.a r19 = BlendToken.OUI_Color_State_Press_Dark;
        com.obric.oui.color.a r110 = BlendToken.OUI_Color_State_Active_Dark;
        a r52 = a.a.b(r18, r19, r110, 42);
        com.obric.oui.fluid.a r111 = FluidToken.OUI_Effect_Fluid_Thin_Dark;
        c r112 = new c(null, r52, null, null, null, Float.valueOf(r3), r14, r111, 125);
        DoubaoV2_Bg_Chip_Fluid_Dark = r112;
        a r53 = a.a.b(DoubaoBlendTokenV2.getDoubaoV2_Color_Blend_Frost_Thin_Light(), r9, r12, 42);
        i0 r23 = StrokeToken.OUI_Effect_Stroke_UltraThin_Light;
        c r24 = new c(null, r53, null, r23, null, Float.valueOf(r3), r14, null, 621);
        DoubaoV2_Bg_Chip_Frost_Light = r24;
        c r25 = new c(null, a.a.b(DoubaoBlendTokenV2.getDoubaoV2_Color_Blend_Frost_Thin_Dark(), r19, r110, 42), null, r5, null, Float.valueOf(r3), r14, null, 621);
        DoubaoV2_Bg_Chip_Frost_Dark = r25;
        DoubaoV2_Bg_Chip_Light = new c[]{r24, r15};
        DoubaoV2_Bg_Chip_Dark = new c[]{r25, r112};
        DoubaoV2_Bg_Chip = new r();
        com.obric.oui.color.a[] r26 = DoubaoBlendTokenV2.getDoubaoV2_Color_Blend_Fluid_Thin_Light();
        com.obric.oui.color.a r27 = com.obric.oui.color.a.c;
        c r29 = new c(null, a.a.b(r26, r27, r12, 42), DoubaoBlendTokenV2.getDoubaoV2_Color_Blend_Fluid_Thin_Light(), null, null, Float.valueOf(r3), r14, r49, ApWakeEvent.WALKING_END);
        DoubaoV2_Bg_Task_Skill_Chip_Fluid_Light = r29;
        c r113 = new c(null, a.a.b(DoubaoBlendTokenV2.getDoubaoV2_Color_Blend_Fluid_Thin_Dark(), r27, r110, 42), null, null, null, Float.valueOf(r3), r14, r111, 125);
        DoubaoV2_Bg_Task_Skill_Chip_Fluid_Dark = r113;
        c r30 = new c(null, a.a.b(DoubaoBlendTokenV2.getDoubaoV2_Color_Blend_Frost_Thin_Light(), r27, r12, 42), null, r23, null, Float.valueOf(r3), r14, null, 621);
        DoubaoV2_Bg_Task_Skill_Chip_Frost_Light = r30;
        c r31 = new c(null, a.a.b(DoubaoBlendTokenV2.getDoubaoV2_Color_Blend_Frost_Thin_Dark(), r27, r110, 42), null, r5, null, Float.valueOf(r3), r14, null, 621);
        DoubaoV2_Bg_Task_Skill_Chip_Frost_Dark = r31;
        DoubaoV2_Bg_Task_Skill_Chip_Light = new c[]{r30, r29};
        DoubaoV2_Bg_Task_Skill_Chip_Dark = new c[]{r31, r113};
        DoubaoV2_Bg_Task_Skill_Chip = new s();
        c r32 = new c(null, a.a.b(DoubaoBlendTokenV2.getDoubaoV2_Color_Blend_Fluid_Thin_Blue_Light(), r9, null, 58), null, null, null, Float.valueOf(r3), r14, r111, 125);
        DoubaoV2_Bg_Chip_Selected_Fluid_Light = r32;
        c r33 = new c(null, a.a.b(DoubaoBlendTokenV2.getDoubaoV2_Color_Blend_Fluid_Thin_Blue_Dark(), r19, null, 58), null, null, null, Float.valueOf(r3), r14, r111, 125);
        DoubaoV2_Bg_Chip_Selected_Fluid_Dark = r33;
        c r34 = new c(null, a.a.b(DoubaoBlendTokenV2.getDoubaoV2_Color_Blend_Frost_Thin_Blue_Light(), r9, null, 58), null, r10, null, Float.valueOf(r3), r14, null, 621);
        DoubaoV2_Bg_Chip_Selected_Frost_Light = r34;
        c r114 = new c(null, a.a.b(DoubaoBlendTokenV2.getDoubaoV2_Color_Blend_Frost_Thin_Blue_Dark(), r19, null, 58), null, r5, null, Float.valueOf(r3), r14, null, 621);
        DoubaoV2_Bg_Chip_Selected_Frost_Dark = r114;
        DoubaoV2_Bg_Chip_Selected_Light = new c[]{r34, r32};
        DoubaoV2_Bg_Chip_Selected_Dark = new c[]{r114, r33};
        DoubaoV2_Bg_Chip_Selected = new t();
        c r35 = new c(null, a.a.b(DoubaoBlendTokenV2.getDoubaoV2_Color_Blend_Fluid_Thin_Blue_Light(), r27, null, 58), null, null, null, Float.valueOf(r3), r14, r111, 125);
        DoubaoV2_Bg_Task_Skill_Chip_Selected_Fluid_Light = r35;
        c r36 = new c(null, a.a.b(DoubaoBlendTokenV2.getDoubaoV2_Color_Blend_Fluid_Thin_Blue_Dark(), r27, null, 58), null, null, null, Float.valueOf(r3), r14, r111, 125);
        DoubaoV2_Bg_Task_Skill_Chip_Selected_Fluid_Dark = r36;
        c r37 = new c(null, a.a.b(DoubaoBlendTokenV2.getDoubaoV2_Color_Blend_Frost_Thin_Blue_Light(), r27, null, 58), null, r10, null, Float.valueOf(r3), r14, null, 621);
        DoubaoV2_Bg_Task_Skill_Chip_Selected_Frost_Light = r37;
        c r38 = new c(null, a.a.b(DoubaoBlendTokenV2.getDoubaoV2_Color_Blend_Frost_Thin_Blue_Dark(), r27, null, 58), null, r5, null, Float.valueOf(r3), r14, null, 621);
        DoubaoV2_Bg_Task_Skill_Chip_Selected_Frost_Dark = r38;
        DoubaoV2_Bg_Task_Skill_Chip_Selected_Light = new c[]{r37, r35};
        DoubaoV2_Bg_Task_Skill_Chip_Selected_Dark = new c[]{r38, r36};
        DoubaoV2_Bg_Task_Skill_Chip_Selected = new u();
        com.obric.oui.color.a[] r41 = DoubaoBlendTokenV2.DoubaoV2_Color_Blend_Frost_Thick_Light;
        float r210 = BlurToken.Blur_UltraThick;
        c r42 = new c(null, null, r41, null, null, Float.valueOf(r210), null, null, 891);
        DoubaoV2_Bg_Modal_Frost_Light = r42;
        c r43 = new c(null, null, DoubaoBlendTokenV2.DoubaoV2_Color_Blend_Frost_Thick_Dark, null, null, Float.valueOf(r210), null, null, 891);
        DoubaoV2_Bg_Modal_Frost_Dark = r43;
        c r44 = new c(null, null, DoubaoBlendTokenV2.DoubaoV2_Color_Blend_Fluid_Thick_Light, null, null, Float.valueOf(r210), null, r17, 379);
        DoubaoV2_Bg_Modal_Fluid_Light = r44;
        c r45 = new c(null, null, DoubaoBlendTokenV2.DoubaoV2_Color_Blend_Fluid_Thick_Dark, null, null, Float.valueOf(r210), null, r28, 379);
        DoubaoV2_Bg_Modal_Fluid_Dark = r45;
        DoubaoV2_Bg_Modal_Light = new c[]{r42, r44};
        DoubaoV2_Bg_Modal_Dark = new c[]{r43, r45};
        DoubaoV2_Bg_Modal = new v();
    }

    public static final Function1<Boolean, c[]> getDoubaoV2_Bg_Chip() {
        return DoubaoV2_Bg_Chip;
    }

    public static final c[] getDoubaoV2_Bg_Chip_Dark() {
        return DoubaoV2_Bg_Chip_Dark;
    }

    public static final c getDoubaoV2_Bg_Chip_Fluid_Dark() {
        return DoubaoV2_Bg_Chip_Fluid_Dark;
    }

    public static final c getDoubaoV2_Bg_Chip_Fluid_Light() {
        return DoubaoV2_Bg_Chip_Fluid_Light;
    }

    public static final c getDoubaoV2_Bg_Chip_Frost_Dark() {
        return DoubaoV2_Bg_Chip_Frost_Dark;
    }

    public static final c getDoubaoV2_Bg_Chip_Frost_Light() {
        return DoubaoV2_Bg_Chip_Frost_Light;
    }

    public static final c[] getDoubaoV2_Bg_Chip_Light() {
        return DoubaoV2_Bg_Chip_Light;
    }

    public static final Function1<Boolean, c[]> getDoubaoV2_Bg_Chip_Selected() {
        return DoubaoV2_Bg_Chip_Selected;
    }

    public static final c[] getDoubaoV2_Bg_Chip_Selected_Dark() {
        return DoubaoV2_Bg_Chip_Selected_Dark;
    }

    public static final c getDoubaoV2_Bg_Chip_Selected_Fluid_Dark() {
        return DoubaoV2_Bg_Chip_Selected_Fluid_Dark;
    }

    public static final c getDoubaoV2_Bg_Chip_Selected_Fluid_Light() {
        return DoubaoV2_Bg_Chip_Selected_Fluid_Light;
    }

    public static final c getDoubaoV2_Bg_Chip_Selected_Frost_Dark() {
        return DoubaoV2_Bg_Chip_Selected_Frost_Dark;
    }

    public static final c getDoubaoV2_Bg_Chip_Selected_Frost_Light() {
        return DoubaoV2_Bg_Chip_Selected_Frost_Light;
    }

    public static final c[] getDoubaoV2_Bg_Chip_Selected_Light() {
        return DoubaoV2_Bg_Chip_Selected_Light;
    }

    public static final Function1<Boolean, c[]> getDoubaoV2_Bg_Floating() {
        return DoubaoV2_Bg_Floating;
    }

    public static final c[] getDoubaoV2_Bg_Floating_Dark() {
        return DoubaoV2_Bg_Floating_Dark;
    }

    public static final c getDoubaoV2_Bg_Floating_Fluid_Dark() {
        return DoubaoV2_Bg_Floating_Fluid_Dark;
    }

    public static final c getDoubaoV2_Bg_Floating_Fluid_Light() {
        return DoubaoV2_Bg_Floating_Fluid_Light;
    }

    public static final c getDoubaoV2_Bg_Floating_Frost_Dark() {
        return DoubaoV2_Bg_Floating_Frost_Dark;
    }

    public static final c getDoubaoV2_Bg_Floating_Frost_Light() {
        return DoubaoV2_Bg_Floating_Frost_Light;
    }

    public static final c[] getDoubaoV2_Bg_Floating_Light() {
        return DoubaoV2_Bg_Floating_Light;
    }

    public static final Function1<Boolean, c[]> getDoubaoV2_Bg_Modal() {
        return DoubaoV2_Bg_Modal;
    }

    public static final Function1<Boolean, c[]> getDoubaoV2_Bg_Task_Skill_Chip() {
        return DoubaoV2_Bg_Task_Skill_Chip;
    }

    public static final c[] getDoubaoV2_Bg_Task_Skill_Chip_Dark() {
        return DoubaoV2_Bg_Task_Skill_Chip_Dark;
    }

    public static final c getDoubaoV2_Bg_Task_Skill_Chip_Fluid_Dark() {
        return DoubaoV2_Bg_Task_Skill_Chip_Fluid_Dark;
    }

    public static final c getDoubaoV2_Bg_Task_Skill_Chip_Fluid_Light() {
        return DoubaoV2_Bg_Task_Skill_Chip_Fluid_Light;
    }

    public static final c getDoubaoV2_Bg_Task_Skill_Chip_Frost_Dark() {
        return DoubaoV2_Bg_Task_Skill_Chip_Frost_Dark;
    }

    public static final c getDoubaoV2_Bg_Task_Skill_Chip_Frost_Light() {
        return DoubaoV2_Bg_Task_Skill_Chip_Frost_Light;
    }

    public static final c[] getDoubaoV2_Bg_Task_Skill_Chip_Light() {
        return DoubaoV2_Bg_Task_Skill_Chip_Light;
    }

    public static final Function1<Boolean, c[]> getDoubaoV2_Bg_Task_Skill_Chip_Selected() {
        return DoubaoV2_Bg_Task_Skill_Chip_Selected;
    }

    public static final c[] getDoubaoV2_Bg_Task_Skill_Chip_Selected_Dark() {
        return DoubaoV2_Bg_Task_Skill_Chip_Selected_Dark;
    }

    public static final c getDoubaoV2_Bg_Task_Skill_Chip_Selected_Fluid_Dark() {
        return DoubaoV2_Bg_Task_Skill_Chip_Selected_Fluid_Dark;
    }

    public static final c getDoubaoV2_Bg_Task_Skill_Chip_Selected_Fluid_Light() {
        return DoubaoV2_Bg_Task_Skill_Chip_Selected_Fluid_Light;
    }

    public static final c getDoubaoV2_Bg_Task_Skill_Chip_Selected_Frost_Dark() {
        return DoubaoV2_Bg_Task_Skill_Chip_Selected_Frost_Dark;
    }

    public static final c getDoubaoV2_Bg_Task_Skill_Chip_Selected_Frost_Light() {
        return DoubaoV2_Bg_Task_Skill_Chip_Selected_Frost_Light;
    }

    public static final c[] getDoubaoV2_Bg_Task_Skill_Chip_Selected_Light() {
        return DoubaoV2_Bg_Task_Skill_Chip_Selected_Light;
    }

    private static final c[] DoubaoV2_Bg_Chip$lambda$1(boolean r1) {
        if (r1 == true) goto L10;
        if (r1 == true) goto L9;
        return DoubaoV2_Bg_Chip_Dark;
    L9:
        throw new NoWhenBranchMatchedException();
    L10:
        return DoubaoV2_Bg_Chip_Light;
    }

    private static final c[] DoubaoV2_Bg_Chip_Selected$lambda$3(boolean r1) {
        if (r1 == true) goto L10;
        if (r1 == true) goto L9;
        return DoubaoV2_Bg_Chip_Selected_Dark;
    L9:
        throw new NoWhenBranchMatchedException();
    L10:
        return DoubaoV2_Bg_Chip_Selected_Light;
    }

    private static final c[] DoubaoV2_Bg_Floating$lambda$0(boolean r1) {
        if (r1 == true) goto L10;
        if (r1 == true) goto L9;
        return DoubaoV2_Bg_Floating_Dark;
    L9:
        throw new NoWhenBranchMatchedException();
    L10:
        return DoubaoV2_Bg_Floating_Light;
    }

    private static final c[] DoubaoV2_Bg_Modal$lambda$5(boolean r1) {
        if (r1 == true) goto L10;
        if (r1 == true) goto L9;
        return DoubaoV2_Bg_Modal_Dark;
    L9:
        throw new NoWhenBranchMatchedException();
    L10:
        return DoubaoV2_Bg_Modal_Light;
    }

    private static final c[] DoubaoV2_Bg_Task_Skill_Chip$lambda$2(boolean r1) {
        if (r1 == true) goto L10;
        if (r1 == true) goto L9;
        return DoubaoV2_Bg_Task_Skill_Chip_Dark;
    L9:
        throw new NoWhenBranchMatchedException();
    L10:
        return DoubaoV2_Bg_Task_Skill_Chip_Light;
    }

    private static final c[] DoubaoV2_Bg_Task_Skill_Chip_Selected$lambda$4(boolean r1) {
        if (r1 == true) goto L10;
        if (r1 == true) goto L9;
        return DoubaoV2_Bg_Task_Skill_Chip_Selected_Dark;
    L9:
        throw new NoWhenBranchMatchedException();
    L10:
        return DoubaoV2_Bg_Task_Skill_Chip_Selected_Light;
    }
}
