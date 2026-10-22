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
import androidx.constraintlayout.widget.R;
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

    public MotionEffect(Context r10) {
        super(r10);
        this.motionEffectAlpha = 0.1f;
        this.motionEffectStart = 49;
        this.motionEffectEnd = 50;
        this.motionEffectTranslationX = 0;
        this.motionEffectTranslationY = 0;
        this.motionEffectStrictMove = true;
        this.viewTransitionId = -1;
        this.fadeMove = -1;
    }

    public MotionEffect(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.motionEffectAlpha = 0.1f;
        this.motionEffectStart = 49;
        this.motionEffectEnd = 50;
        this.motionEffectTranslationX = 0;
        this.motionEffectTranslationY = 0;
        this.motionEffectStrictMove = true;
        this.viewTransitionId = -1;
        this.fadeMove = -1;
        init(r10, r11);
    }

    public MotionEffect(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.motionEffectAlpha = 0.1f;
        this.motionEffectStart = 49;
        this.motionEffectEnd = 50;
        this.motionEffectTranslationX = 0;
        this.motionEffectTranslationY = 0;
        this.motionEffectStrictMove = true;
        this.viewTransitionId = -1;
        this.fadeMove = -1;
        init(r10, r11);
    }

    private void init(Context r10, AttributeSet r11) {
        if (r11 == null) goto L47;
        TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.MotionEffect);
        int r13 = r12.getIndexCount();
        int r14 = 0;
    L4:
        if (r14 >= r13) goto L30;
        int r15 = r12.getIndex(r14);
        if (r15 != R.styleable.MotionEffect_motionEffect_start) goto L9;
        int r16 = r12.getInt(r15, this.motionEffectStart);
        this.motionEffectStart = r16;
        this.motionEffectStart = Math.max(Math.min(r16, 99), 0);
    L29:
        r14 = r14 + 1;
        goto L4
    L9:
        if (r15 != R.styleable.MotionEffect_motionEffect_end) goto L12;
        int r17 = r12.getInt(r15, this.motionEffectEnd);
        this.motionEffectEnd = r17;
        this.motionEffectEnd = Math.max(Math.min(r17, 99), 0);
        goto L29
    L12:
        if (r15 != R.styleable.MotionEffect_motionEffect_translationX) goto L15;
        this.motionEffectTranslationX = r12.getDimensionPixelOffset(r15, this.motionEffectTranslationX);
        goto L29
    L15:
        if (r15 != R.styleable.MotionEffect_motionEffect_translationY) goto L18;
        this.motionEffectTranslationY = r12.getDimensionPixelOffset(r15, this.motionEffectTranslationY);
        goto L29
    L18:
        if (r15 != R.styleable.MotionEffect_motionEffect_alpha) goto L21;
        this.motionEffectAlpha = r12.getFloat(r15, this.motionEffectAlpha);
        goto L29
    L21:
        if (r15 != R.styleable.MotionEffect_motionEffect_move) goto L24;
        this.fadeMove = r12.getInt(r15, this.fadeMove);
        goto L29
    L24:
        if (r15 != R.styleable.MotionEffect_motionEffect_strict) goto L27;
        this.motionEffectStrictMove = r12.getBoolean(r15, this.motionEffectStrictMove);
        goto L29
    L27:
        if (r15 != R.styleable.MotionEffect_motionEffect_viewTransition) goto L29;
        this.viewTransitionId = r12.getResourceId(r15, this.viewTransitionId);
        goto L29
    L30:
        int r18 = this.motionEffectStart;
        int r19 = this.motionEffectEnd;
        if (r18 != r19) goto L35;
        if (r18 <= 0) goto L34;
        this.motionEffectStart = r18 - 1;
        goto L35
    L34:
        this.motionEffectEnd = r19 + 1;
    L35:
        r12.recycle();
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionHelperInterface
    public boolean isDecorator() {
        return true;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionHelperInterface
    public void onPreSetup(MotionLayout r22, HashMap<View, MotionController> r23) {
        HashMap<View, MotionController> r10 = r23;
        View[] r11 = getViews((ConstraintLayout) getParent());
        if (r11 != null) goto L6;
        Log.v(TAG, Debug.getLoc() + " views = null");
        return;
    L6:
        Key r12 = new KeyAttributes();
        Key r13 = new KeyAttributes();
        r12.setValue("alpha", Float.valueOf(this.motionEffectAlpha));
        r13.setValue("alpha", Float.valueOf(this.motionEffectAlpha));
        r12.setFramePosition(this.motionEffectStart);
        r13.setFramePosition(this.motionEffectEnd);
        KeyPosition r14 = new KeyPosition();
        r14.setFramePosition(this.motionEffectStart);
        r14.setType(0);
        r14.setValue("percentX", 0);
        r14.setValue("percentY", 0);
        KeyPosition r15 = new KeyPosition();
        r15.setFramePosition(this.motionEffectEnd);
        r15.setType(0);
        r15.setValue("percentX", 1);
        r15.setValue("percentY", 1);
        Key r16 = null;
        if (this.motionEffectTranslationX <= 0) goto L9;
        Key r17 = new KeyAttributes();
        Key r18 = new KeyAttributes();
        r17.setValue("translationX", Integer.valueOf(this.motionEffectTranslationX));
        r17.setFramePosition(this.motionEffectEnd);
        r18.setValue("translationX", 0);
        r18.setFramePosition(this.motionEffectEnd - 1);
    L11:
        if (this.motionEffectTranslationY <= 0) goto L13;
        r16 = new KeyAttributes();
        Key r19 = new KeyAttributes();
        r16.setValue("translationY", Integer.valueOf(this.motionEffectTranslationY));
        r16.setFramePosition(this.motionEffectEnd);
        r19.setValue("translationY", 0);
        r19.setFramePosition(this.motionEffectEnd - 1);
    L14:
        int r110 = this.fadeMove;
        if (r110 != (-1)) goto L42;
        int[] r111 = new int[4];
        int r112 = 0;
    L18:
        if (r112 >= r11.length) goto L35;
        MotionController r113 = r10.get(r11[r112]);
        if (r113 == null) goto L34;
        float r114 = r113.getFinalX() - r113.getStartX();
        float r20 = r113.getFinalY() - r113.getStartY();
        if (r20 >= 0.0f) goto L26;
        r111[1] = r111[1] + 1;
    L26:
        if (r20 <= 0.0f) goto L29;
        r111[0] = r111[0] + 1;
    L29:
        if (r114 <= 0.0f) goto L32;
        r111[3] = r111[3] + 1;
    L32:
        if (r114 >= 0.0f) goto L34;
        r111[2] = r111[2] + 1;
    L34:
        r112 = r112 + 1;
        goto L18
    L35:
        int r115 = r111[0];
        r110 = 0;
        int r21 = 1;
    L37:
        if (r21 >= 4) goto L42;
        if (r115 >= r111[r21]) goto L41;
        r110 = r21;
        r115 = r111[r21];
    L41:
        r21 = r21 + 1;
    L42:
        int r24 = 0;
    L44:
        if (r24 >= r11.length) goto L99;
        MotionController r116 = r10.get(r11[r24]);
        if (r116 == null) goto L98;
        float r117 = r116.getFinalX() - r116.getStartX();
        float r118 = r116.getFinalY() - r116.getStartY();
        if (r110 != 0) goto L60;
        if (r118 <= 0.0f) goto L86;
        if (this.motionEffectStrictMove == false) goto L57;
        if (r117 != 0.0f) goto L86;
    L57:
        boolean r119 = false;
    L87:
        if (r119 == false) goto L98;
        int r120 = this.viewTransitionId;
        if (r120 != (-1)) goto L97;
        r116.addKey(r12);
        r116.addKey(r13);
        r116.addKey(r14);
        r116.addKey(r15);
        if (this.motionEffectTranslationX <= 0) goto L94;
        r116.addKey(r17);
        r116.addKey(r18);
    L94:
        if (this.motionEffectTranslationY <= 0) goto L98;
        r116.addKey(r16);
        r116.addKey(r19);
        goto L98
    L97:
        r22.applyViewTransition(r120, r116);
    L86:
        r119 = true;
        goto L87
    L60:
        if (r110 != 1) goto L69;
        if (r118 >= 0.0f) goto L86;
        if (this.motionEffectStrictMove == false) goto L57;
        if (r117 != 0.0f) goto L86;
    L69:
        if (r110 != 2) goto L78;
        if (r117 >= 0.0f) goto L86;
        if (this.motionEffectStrictMove == false) goto L57;
        if (r118 != 0.0f) goto L86;
    L78:
        if (r110 != 3) goto L86;
        if (r117 <= 0.0f) goto L86;
        if (this.motionEffectStrictMove == false) goto L57;
        if (r118 != 0.0f) goto L86;
    L98:
        r24 = r24 + 1;
        r10 = r23;
        goto L44
    L99:
        return;
    L13:
        r19 = null;
        goto L14
    L9:
        r17 = null;
        r18 = null;
        goto L11
    }
}
