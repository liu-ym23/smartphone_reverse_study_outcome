package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.KeyAttributes;
import androidx.constraintlayout.motion.widget.KeyPosition;
import androidx.constraintlayout.motion.widget.MotionController;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class MotionEffect extends MotionHelper {
    public static final int AUTO = -1;
    public static final int EAST = 2;
    public static final int NORTH = 0;
    public static final int SOUTH = 1;
    public static final String TAG = "FadeMove";
    private static final int UNSET = -1;
    public static final int WEST = 3;
    private int fadeMove;
    private float motionEffectAlpha;
    private int motionEffectEnd;
    private int motionEffectStart;
    private boolean motionEffectStrictMove;
    private int motionEffectTranslationX;
    private int motionEffectTranslationY;
    private int viewTransitionId;

    public MotionEffect(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        this.motionEffectAlpha = 0.1f;
        this.motionEffectStart = 49;
        this.motionEffectEnd = 50;
        this.motionEffectTranslationX = 0;
        this.motionEffectTranslationY = 0;
        this.motionEffectStrictMove = true;
        this.viewTransitionId = -1;
        this.fadeMove = -1;
    }

    public MotionEffect(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r5, r6);
        this.motionEffectAlpha = 0.1f;
        this.motionEffectStart = 49;
        this.motionEffectEnd = 50;
        this.motionEffectTranslationX = 0;
        this.motionEffectTranslationY = 0;
        this.motionEffectStrictMove = true;
        this.viewTransitionId = -1;
        this.fadeMove = -1;
        init(r5, r6);
    }

    public MotionEffect(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7, r5);
        this.motionEffectAlpha = 0.1f;
        this.motionEffectStart = 49;
        this.motionEffectEnd = 50;
        this.motionEffectTranslationX = 0;
        this.motionEffectTranslationY = 0;
        this.motionEffectStrictMove = true;
        this.viewTransitionId = -1;
        this.fadeMove = -1;
        init(r6, r7);
    }

    private void init(Context r8, AttributeSet r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L48;
        TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.MotionEffect);
        int r13 = r12.getIndexCount();
        int r1 = 0;
    L5:
        if (r1 >= r13) goto L31;
        int r2 = r12.getIndex(r1);
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionEffect_motionEffect_start, "styleable", "MotionEffect_motionEffect_start")) goto L10;
        int r3 = r12.getInt(r2, this.motionEffectStart);
        this.motionEffectStart = r3;
        this.motionEffectStart = Math.max(Math.min(r3, 99), 0);
    L30:
        r1 = r1 + 1;
        goto L5
    L10:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionEffect_motionEffect_end, "styleable", "MotionEffect_motionEffect_end")) goto L13;
        int r4 = r12.getInt(r2, this.motionEffectEnd);
        this.motionEffectEnd = r4;
        this.motionEffectEnd = Math.max(Math.min(r4, 99), 0);
        goto L30
    L13:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionEffect_motionEffect_translationX, "styleable", "MotionEffect_motionEffect_translationX")) goto L16;
        this.motionEffectTranslationX = r12.getDimensionPixelOffset(r2, this.motionEffectTranslationX);
        goto L30
    L16:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionEffect_motionEffect_translationY, "styleable", "MotionEffect_motionEffect_translationY")) goto L19;
        this.motionEffectTranslationY = r12.getDimensionPixelOffset(r2, this.motionEffectTranslationY);
        goto L30
    L19:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionEffect_motionEffect_alpha, "styleable", "MotionEffect_motionEffect_alpha")) goto L22;
        this.motionEffectAlpha = r12.getFloat(r2, this.motionEffectAlpha);
        goto L30
    L22:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionEffect_motionEffect_move, "styleable", "MotionEffect_motionEffect_move")) goto L25;
        this.fadeMove = r12.getInt(r2, this.fadeMove);
        goto L30
    L25:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionEffect_motionEffect_strict, "styleable", "MotionEffect_motionEffect_strict")) goto L28;
        this.motionEffectStrictMove = r12.getBoolean(r2, this.motionEffectStrictMove);
        goto L30
    L28:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionEffect_motionEffect_viewTransition, "styleable", "MotionEffect_motionEffect_viewTransition")) goto L30;
        this.viewTransitionId = r12.getResourceId(r2, this.viewTransitionId);
        goto L30
    L31:
        int r14 = this.motionEffectStart;
        int r0 = this.motionEffectEnd;
        if (r14 != r0) goto L36;
        if (r14 <= 0) goto L35;
        this.motionEffectStart = r14 - 1;
        goto L36
    L35:
        this.motionEffectEnd = r0 + 1;
    L36:
        r12.recycle();
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionHelperInterface
    public boolean isDecorator() {
        return true;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionHelperInterface
    public void onPreSetup(MotionLayout r24, HashMap<View, MotionController> r25) {
        HashMap<View, MotionController> r1 = r25;
        View[] r2 = getViews((ConstraintLayout) ZeusTransformUtils.preCheckCast(getParent(), ConstraintLayout.class, "com.obric.memorydata.plugin"));
        if (r2 != null) goto L6;
        Log.v(TAG, Debug.getLoc() + " views = null");
        return;
    L6:
        Key r3 = new KeyAttributes();
        Key r5 = new KeyAttributes();
        r3.setValue("alpha", Float.valueOf(this.motionEffectAlpha));
        r5.setValue("alpha", Float.valueOf(this.motionEffectAlpha));
        r3.setFramePosition(this.motionEffectStart);
        r5.setFramePosition(this.motionEffectEnd);
        KeyPosition r6 = new KeyPosition();
        r6.setFramePosition(this.motionEffectStart);
        r6.setType(0);
        r6.setValue("percentX", 0);
        r6.setValue("percentY", 0);
        KeyPosition r8 = new KeyPosition();
        r8.setFramePosition(this.motionEffectEnd);
        r8.setType(0);
        r8.setValue("percentX", 1);
        r8.setValue("percentY", 1);
        Key r10 = null;
        if (this.motionEffectTranslationX <= 0) goto L9;
        Key r9 = new KeyAttributes();
        Key r12 = new KeyAttributes();
        r9.setValue("translationX", Integer.valueOf(this.motionEffectTranslationX));
        r9.setFramePosition(this.motionEffectEnd);
        r12.setValue("translationX", 0);
        r12.setFramePosition(this.motionEffectEnd - 1);
    L11:
        if (this.motionEffectTranslationY <= 0) goto L13;
        r10 = new KeyAttributes();
        Key r13 = new KeyAttributes();
        r10.setValue("translationY", Integer.valueOf(this.motionEffectTranslationY));
        r10.setFramePosition(this.motionEffectEnd);
        r13.setValue("translationY", 0);
        r13.setFramePosition(this.motionEffectEnd - 1);
    L14:
        int r14 = this.fadeMove;
        if (r14 != (-1)) goto L43;
        int[] r15 = new int[4];
        int r16 = 0;
    L18:
        if (r16 >= r2.length) goto L36;
        MotionController r7 = (MotionController) ZeusTransformUtils.preCheckCast(r1.get(r2[r16]), MotionController.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L35;
        float r11 = r7.getFinalX() - r7.getStartX();
        float r22 = r7.getFinalY() - r7.getStartY();
        if (r22 >= 0.0f) goto L27;
        r15[1] = r15[1] + 1;
    L27:
        if (r22 <= 0.0f) goto L30;
        r15[0] = r15[0] + 1;
    L30:
        if (r11 <= 0.0f) goto L33;
        r15[3] = r15[3] + 1;
    L33:
        if (r11 >= 0.0f) goto L35;
        r15[2] = r15[2] + 1;
    L35:
        r16 = r16 + 1;
        goto L18
    L36:
        int r19 = 0;
        int r17 = r15[0];
        int r18 = 4;
        int r110 = 1;
    L37:
        if (r110 >= r18) goto L42;
        if (r17 >= r15[r110]) goto L41;
        r17 = r15[r110];
        r19 = r110;
    L41:
        r110 = r110 + 1;
        r18 = 4;
        goto L37
    L42:
        r14 = r19;
    L43:
        int r20 = 0;
    L45:
        if (r20 >= r2.length) goto L99;
        MotionController r111 = (MotionController) ZeusTransformUtils.preCheckCast(r1.get(r2[r20]), MotionController.class, "com.obric.memorydata.plugin");
        if (r111 == null) goto L98;
        float r112 = r111.getFinalX() - r111.getStartX();
        float r113 = r111.getFinalY() - r111.getStartY();
        if (r14 != 0) goto L61;
        if (r113 <= 0.0f) goto L87;
        if (this.motionEffectStrictMove == false) goto L58;
        if (r112 != 0.0f) goto L87;
    L58:
        boolean r114 = false;
    L88:
        if (r114 == false) goto L98;
        int r115 = this.viewTransitionId;
        if (r115 != (-1)) goto L97;
        r111.addKey(r3);
        r111.addKey(r5);
        r111.addKey(r6);
        r111.addKey(r8);
        if (this.motionEffectTranslationX <= 0) goto L95;
        r111.addKey(r9);
        r111.addKey(r12);
    L95:
        if (this.motionEffectTranslationY <= 0) goto L98;
        r111.addKey(r10);
        r111.addKey(r13);
        goto L98
    L97:
        r24.applyViewTransition(r115, r111);
    L87:
        r114 = true;
        goto L88
    L61:
        if (r14 != 1) goto L70;
        if (r113 >= 0.0f) goto L87;
        if (this.motionEffectStrictMove == false) goto L58;
        if (r112 != 0.0f) goto L87;
    L70:
        if (r14 != 2) goto L79;
        if (r112 >= 0.0f) goto L87;
        if (this.motionEffectStrictMove == false) goto L58;
        if (r113 != 0.0f) goto L87;
    L79:
        if (r14 != 3) goto L87;
        if (r112 <= 0.0f) goto L87;
        if (this.motionEffectStrictMove == false) goto L58;
        if (r113 != 0.0f) goto L87;
    L98:
        r20 = r20 + 1;
        r1 = r25;
        goto L45
    L99:
        return;
    L13:
        r13 = null;
        goto L14
    L9:
        r9 = null;
        r12 = null;
        goto L11
    }
}
