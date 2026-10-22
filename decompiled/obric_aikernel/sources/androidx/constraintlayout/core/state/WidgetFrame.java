package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class WidgetFrame {
    private static final boolean OLD_SYSTEM = true;
    public static float phone_orientation = Float.NaN;
    public float alpha;
    public int bottom;
    public float interpolatedPos;
    public int left;
    public final HashMap<String, CustomVariable> mCustom;
    public String name;
    public float pivotX;
    public float pivotY;
    public int right;
    public float rotationX;
    public float rotationY;
    public float rotationZ;
    public float scaleX;
    public float scaleY;
    public int top;
    public float translationX;
    public float translationY;
    public float translationZ;
    public int visibility;
    public ConstraintWidget widget;

    static {
    }

    public WidgetFrame() {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap();
        this.name = null;
    }

    public WidgetFrame(WidgetFrame r10) {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap();
        this.name = null;
        this.widget = r10.widget;
        this.left = r10.left;
        this.top = r10.top;
        this.right = r10.right;
        this.bottom = r10.bottom;
        updateAttributes(r10);
    }

    public WidgetFrame(ConstraintWidget r10) {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap();
        this.name = null;
        this.widget = r10;
    }

    private static void add(StringBuilder r10, String r11, float r12) {
        if (Float.isNaN(r12) == false) goto L5;
        return;
    L5:
        r10.append(r11);
        r10.append(": ");
        r10.append(r12);
        r10.append(",\n");
    }

    private static void add(StringBuilder r10, String r11, int r12) {
        r10.append(r11);
        r10.append(": ");
        r10.append(r12);
        r10.append(",\n");
    }

    private static float interpolate(float r10, float r11, float r12, float r13) {
        boolean r14 = Float.isNaN(r10);
        boolean r15 = Float.isNaN(r11);
        if (r14 == false) goto L7;
        if (r15 == false) goto L7;
        return Float.NaN;
    L7:
        if (r14 == false) goto L9;
        r10 = r12;
    L9:
        if (r15 == false) goto L12;
        r11 = r12;
    L12:
        return r10 + (r13 * (r11 - r10));
    }

    public static void interpolate(int r21, int r22, WidgetFrame r23, WidgetFrame r24, WidgetFrame r25, Transition r26, float r27) {
        float r10 = 100.0f * r27;
        int r11 = (int) r10;
        int r12 = r24.left;
        int r13 = r24.top;
        int r14 = r25.left;
        int r15 = r25.top;
        int r16 = r24.right - r12;
        int r17 = r24.bottom - r13;
        int r18 = r25.right - r14;
        int r19 = r25.bottom - r15;
        float r110 = r24.alpha;
        float r20 = r25.alpha;
        if (r24.visibility != 8) goto L8;
        r12 = (int) (r12 - (r18 / 2.0f));
        r13 = (int) (r13 - (r19 / 2.0f));
        if (Float.isNaN(r110) == false) goto L7;
        int r111 = r19;
        int r28 = r18;
        float r112 = 0.0f;
    L10:
        if (r25.visibility != 8) goto L15;
        r14 = (int) (r14 - (r28 / 2.0f));
        r15 = (int) (r15 - (r111 / 2.0f));
        r18 = r28;
        r19 = r111;
        if (Float.isNaN(r20) == false) goto L15;
        r20 = 0.0f;
    L15:
        if (Float.isNaN(r112) == false) goto L20;
        if (Float.isNaN(r20) == true) goto L20;
        r112 = 1.0f;
    L20:
        if (Float.isNaN(r112) == true) goto L25;
        if (Float.isNaN(r20) == false) goto L25;
        r20 = 1.0f;
    L25:
        if (r24.visibility != 4) goto L27;
        float r29 = 0.0f;
    L29:
        if (r25.visibility != 4) goto L31;
        float r30 = 0.0f;
    L33:
        if (r23.widget != null) goto L35;
    L46:
        int r210 = r12;
        float r31 = r27;
    L47:
        int r32 = r210;
        r23.widget = r24.widget;
        int r33 = (int) (r32 + ((r14 - r32) * r31));
        r23.left = r33;
        int r34 = (int) (r13 + (r31 * (r15 - r13)));
        r23.top = r34;
        float r113 = 1.0f - r27;
        r23.right = r33 + ((int) ((r28 * r113) + (r18 * r27)));
        r23.bottom = r34 + ((int) ((r113 * r111) + (r19 * r27)));
        r23.pivotX = interpolate(r24.pivotX, r25.pivotX, 0.5f, r27);
        r23.pivotY = interpolate(r24.pivotY, r25.pivotY, 0.5f, r27);
        r23.rotationX = interpolate(r24.rotationX, r25.rotationX, 0.0f, r27);
        r23.rotationY = interpolate(r24.rotationY, r25.rotationY, 0.0f, r27);
        r23.rotationZ = interpolate(r24.rotationZ, r25.rotationZ, 0.0f, r27);
        r23.scaleX = interpolate(r24.scaleX, r25.scaleX, 1.0f, r27);
        r23.scaleY = interpolate(r24.scaleY, r25.scaleY, 1.0f, r27);
        r23.translationX = interpolate(r24.translationX, r25.translationX, 0.0f, r27);
        r23.translationY = interpolate(r24.translationY, r25.translationY, 0.0f, r27);
        r23.translationZ = interpolate(r24.translationZ, r25.translationZ, 0.0f, r27);
        r23.alpha = interpolate(r29, r30, 1.0f, r27);
        Set<String> r35 = r25.mCustom.keySet();
        r23.mCustom.clear();
        Iterator<String> r36 = r35.iterator();
    L49:
        if (r36.hasNext() == false) goto L59;
        String r37 = r36.next();
        if (r24.mCustom.containsKey(r37) == false) goto L49;
        CustomVariable r38 = r24.mCustom.get(r37);
        CustomVariable r39 = r25.mCustom.get(r37);
        CustomVariable r40 = new CustomVariable(r38);
        r23.mCustom.put(r37, r40);
        if (r38.numberOfInterpolatedValues() != 1) goto L55;
        r40.setValue(Float.valueOf(interpolate(r38.getValueToInterpolate(), r39.getValueToInterpolate(), 0.0f, r27)));
        goto L49
    L55:
        int r41 = r38.numberOfInterpolatedValues();
        float[] r42 = new float[r41];
        float[] r114 = new float[r41];
        r38.getValuesToInterpolate(r42);
        r39.getValuesToInterpolate(r114);
        int r43 = 0;
    L56:
        if (r43 >= r41) goto L49;
        r42[r43] = interpolate(r42[r43], r114[r43], 0.0f, r27);
        r40.setValue(r42);
        r43 = r43 + 1;
        goto L56
    L59:
        return;
    L35:
        if (r26.hasPositionKeyframes() == false) goto L46;
        Transition.KeyPosition r44 = r26.findPreviousPosition(r23.widget.stringId, r11);
        r210 = r12;
        Transition.KeyPosition r45 = r26.findNextPosition(r23.widget.stringId, r11);
        if (r44 != r45) goto L39;
        r45 = null;
    L39:
        if (r44 == null) goto L41;
        r210 = (int) (r44.f244x * r21);
        int r46 = r22;
        r13 = (int) (r44.f245y * r46);
        int r47 = r44.frame;
    L42:
        if (r45 == null) goto L44;
        int r48 = (int) (r45.f244x * r21);
        r14 = r48;
        r15 = (int) (r45.f245y * r46);
        int r49 = r45.frame;
    L45:
        r31 = (r10 - r47) / (r49 - r47);
        goto L47
    L44:
        r49 = 100;
        goto L45
    L41:
        r46 = r22;
        r47 = 0;
        goto L42
    L31:
        r30 = r20;
        goto L33
    L27:
        r29 = r112;
        goto L29
    L7:
        r112 = r110;
        r28 = r18;
        r111 = r19;
        goto L10
    L8:
        r28 = r16;
        r112 = r110;
        r111 = r17;
        goto L10
    }

    private void serializeAnchor(StringBuilder r10, ConstraintAnchor.Type r11) {
        ConstraintAnchor r12 = this.widget.getAnchor(r11);
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.mTarget == null) goto L13;
        r10.append("Anchor");
        r10.append(r11.name());
        r10.append(": ['");
        String r13 = r12.mTarget.getOwner().stringId;
        if (r13 != null) goto L10;
        r13 = "#PARENT";
    L10:
        r10.append(r13);
        r10.append("', '");
        r10.append(r12.mTarget.getType().name());
        r10.append("', '");
        r10.append(r12.mMargin);
        r10.append("'],\n");
        return;
    }

    public void addCustomColor(String r10, int r11) {
        setCustomAttribute(r10, TypedValues.Custom.TYPE_COLOR, r11);
    }

    public void addCustomFloat(String r10, float r11) {
        setCustomAttribute(r10, TypedValues.Custom.TYPE_FLOAT, r11);
    }

    public float centerX() {
        int r10 = this.left;
        return r10 + ((this.right - r10) / 2.0f);
    }

    public float centerY() {
        int r10 = this.top;
        return r10 + ((this.bottom - r10) / 2.0f);
    }

    public CustomVariable getCustomAttribute(String r10) {
        return this.mCustom.get(r10);
    }

    public Set<String> getCustomAttributeNames() {
        return this.mCustom.keySet();
    }

    public int getCustomColor(String r10) {
        if (this.mCustom.containsKey(r10) == true) goto L5;
        return -21880;
    L5:
        return this.mCustom.get(r10).getColorValue();
    }

    public float getCustomFloat(String r10) {
        if (this.mCustom.containsKey(r10) == true) goto L5;
        return Float.NaN;
    L5:
        return this.mCustom.get(r10).getFloatValue();
    }

    public String getId() {
        ConstraintWidget r10 = this.widget;
        if (r10 != null) goto L7;
        return "unknown";
    L7:
        return r10.stringId;
    }

    public int height() {
        return Math.max(0, this.bottom - this.top);
    }

    public boolean isDefaultTransform() {
        if (Float.isNaN(this.rotationX) == true) goto L5;
    L21:
        return false;
    L5:
        if (Float.isNaN(this.rotationY) == false) goto L21;
        if (Float.isNaN(this.rotationZ) == false) goto L21;
        if (Float.isNaN(this.translationX) == false) goto L21;
        if (Float.isNaN(this.translationY) == false) goto L21;
        if (Float.isNaN(this.translationZ) == false) goto L21;
        if (Float.isNaN(this.scaleX) == false) goto L21;
        if (Float.isNaN(this.scaleY) == false) goto L21;
        if (Float.isNaN(this.alpha) == false) goto L21;
        return true;
    }

    void logv(String r10) {
        StackTraceElement r11 = new Throwable().getStackTrace()[1];
        String r12 = (".(" + r11.getFileName() + ":" + r11.getLineNumber() + ") " + r11.getMethodName()) + " " + (hashCode() % 1000);
        if (this.widget == null) goto L5;
        String r13 = r12 + "/" + (this.widget.hashCode() % 1000);
    L6:
        System.out.println(r13 + " " + r10);
        return;
    L5:
        r13 = r12 + "/NULL";
        goto L6
    }

    void parseCustom(CLElement r10) {
        CLObject r11 = (CLObject) r10;
        int r12 = r11.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L12;
        CLKey r14 = (CLKey) r11.get(r13);
        r14.content();
        CLElement r15 = r14.getValue();
        String r16 = r15.content();
        if (r16.matches("#[0-9a-fA-F]+") == false) goto L7;
        int r17 = Integer.parseInt(r16.substring(1), 16);
        setCustomAttribute(r14.content(), TypedValues.Custom.TYPE_COLOR, r17);
    L11:
        r13 = r13 + 1;
        goto L3
    L7:
        boolean r18 = r15 instanceof CLNumber;
        String r19 = r14.content();
        if (r18 == false) goto L10;
        setCustomAttribute(r19, TypedValues.Custom.TYPE_FLOAT, r15.getFloat());
        goto L11
    L10:
        setCustomAttribute(r19, TypedValues.Custom.TYPE_STRING, r16);
        goto L11
    }

    void printCustomAttributes() {
        StackTraceElement r10 = new Throwable().getStackTrace()[1];
        String r11 = (".(" + r10.getFileName() + ":" + r10.getLineNumber() + ") " + r10.getMethodName()) + " " + (hashCode() % 1000);
        if (this.widget == null) goto L5;
        String r12 = r11 + "/" + (this.widget.hashCode() % 1000) + " ";
    L6:
        HashMap<String, CustomVariable> r13 = this.mCustom;
        if (r13 == null) goto L12;
        Iterator<String> r14 = r13.keySet().iterator();
    L10:
        if (r14.hasNext() == false) goto L14;
        String r15 = r14.next();
        System.out.println(r12 + this.mCustom.get(r15).toString());
        goto L10
    L14:
        return;
    L12:
        return;
    L5:
        r12 = r11 + "/NULL ";
        goto L6
    }

    public StringBuilder serialize(StringBuilder r10) {
        return serialize(r10, false);
    }

    public StringBuilder serialize(StringBuilder r10, boolean r11) {
        r10.append("{\n");
        add(r10, "left", this.left);
        add(r10, "top", this.top);
        add(r10, "right", this.right);
        add(r10, "bottom", this.bottom);
        add(r10, "pivotX", this.pivotX);
        add(r10, "pivotY", this.pivotY);
        add(r10, "rotationX", this.rotationX);
        add(r10, "rotationY", this.rotationY);
        add(r10, "rotationZ", this.rotationZ);
        add(r10, "translationX", this.translationX);
        add(r10, "translationY", this.translationY);
        add(r10, "translationZ", this.translationZ);
        add(r10, "scaleX", this.scaleX);
        add(r10, "scaleY", this.scaleY);
        add(r10, "alpha", this.alpha);
        add(r10, "visibility", this.visibility);
        add(r10, "interpolatedPos", this.interpolatedPos);
        if (this.widget == null) goto L8;
        ConstraintAnchor.Type[] r12 = ConstraintAnchor.Type.values();
        int r13 = r12.length;
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L8;
        serializeAnchor(r10, r12[r14]);
        r14 = r14 + 1;
    L8:
        if (r11 == false) goto L10;
        add(r10, "phone_orientation", phone_orientation);
    L10:
        if (r11 == false) goto L13;
        add(r10, "phone_orientation", phone_orientation);
    L13:
        if (this.mCustom.size() == 0) goto L29;
        r10.append("custom : {\n");
        Iterator<String> r15 = this.mCustom.keySet().iterator();
    L16:
        if (r15.hasNext() == false) goto L28;
        String r16 = r15.next();
        CustomVariable r17 = this.mCustom.get(r16);
        r10.append(r16);
        r10.append(": ");
        switch(r17.getType()) {
            case 900: goto L26;
            case 901: goto L25;
            case 902: goto L22;
            case 903: goto L21;
            case 904: goto L20;
            case 905: goto L25;
            default: goto L16;
        };
    L20:
        r10.append("'");
        r10.append(r17.getBooleanValue());
    L24:
        r10.append("',\n");
        goto L16
    L21:
        r10.append("'");
        String r18 = r17.getStringValue();
    L23:
        r10.append(r18);
        goto L24
    L22:
        r10.append("'");
        r18 = CustomVariable.colorString(r17.getIntegerValue());
        goto L23
    L25:
        r10.append(r17.getFloatValue());
    L27:
        r10.append(",\n");
        goto L16
    L26:
        r10.append(r17.getIntegerValue());
        goto L27
    L28:
        r10.append("}\n");
    L29:
        r10.append("}\n");
        return r10;
    }

    public void setCustomAttribute(String r10, int r11, float r12) {
        boolean r13 = this.mCustom.containsKey(r10);
        HashMap<String, CustomVariable> r14 = this.mCustom;
        if (r13 == false) goto L5;
        r14.get(r10).setFloatValue(r12);
        return;
    L5:
        r14.put(r10, new CustomVariable(r10, r11, r12));
    }

    public void setCustomAttribute(String r10, int r11, int r12) {
        boolean r13 = this.mCustom.containsKey(r10);
        HashMap<String, CustomVariable> r14 = this.mCustom;
        if (r13 == false) goto L5;
        r14.get(r10).setIntValue(r12);
        return;
    L5:
        r14.put(r10, new CustomVariable(r10, r11, r12));
    }

    public void setCustomAttribute(String r10, int r11, String r12) {
        boolean r13 = this.mCustom.containsKey(r10);
        HashMap<String, CustomVariable> r14 = this.mCustom;
        if (r13 == false) goto L5;
        r14.get(r10).setStringValue(r12);
        return;
    L5:
        r14.put(r10, new CustomVariable(r10, r11, r12));
    }

    public void setCustomAttribute(String r10, int r11, boolean r12) {
        boolean r13 = this.mCustom.containsKey(r10);
        HashMap<String, CustomVariable> r14 = this.mCustom;
        if (r13 == false) goto L5;
        r14.get(r10).setBooleanValue(r12);
        return;
    L5:
        r14.put(r10, new CustomVariable(r10, r11, r12));
    }

    public void setCustomValue(CustomAttribute r10, float[] r11) {
    }

    public boolean setValue(String r10, CLElement r11) {
        r10.hashCode();
        byte r12 = -1;
        switch(r10.hashCode()) {
            case -1881940865: goto L74;
            case -1383228885: goto L70;
            case -1349088399: goto L66;
            case -1249320806: goto L62;
            case -1249320805: goto L58;
            case -1249320804: goto L54;
            case -1225497657: goto L50;
            case -1225497656: goto L46;
            case -1225497655: goto L42;
            case -987906986: goto L38;
            case -987906985: goto L34;
            case -908189618: goto L30;
            case -908189617: goto L26;
            case 115029: goto L22;
            case 3317767: goto L18;
            case 92909918: goto L14;
            case 108511772: goto L10;
            case 642850769: goto L6;
            default: goto L77;
        };
    L77:
        switch(r12) {
            case 0: goto L96;
            case 1: goto L95;
            case 2: goto L94;
            case 3: goto L93;
            case 4: goto L92;
            case 5: goto L91;
            case 6: goto L90;
            case 7: goto L89;
            case 8: goto L88;
            case 9: goto L87;
            case 10: goto L86;
            case 11: goto L85;
            case 12: goto L84;
            case 13: goto L83;
            case 14: goto L82;
            case 15: goto L81;
            case 16: goto L80;
            case 17: goto L79;
            default: goto L78;
        };
    L78:
        return false;
    L79:
        this.interpolatedPos = r11.getFloat();
    L97:
        return true;
    L80:
        this.right = r11.getInt();
        goto L97
    L81:
        this.alpha = r11.getFloat();
        goto L97
    L82:
        this.left = r11.getInt();
        goto L97
    L83:
        this.top = r11.getInt();
        goto L97
    L84:
        this.scaleY = r11.getFloat();
        goto L97
    L85:
        this.scaleX = r11.getFloat();
        goto L97
    L86:
        this.pivotY = r11.getFloat();
        goto L97
    L87:
        this.pivotX = r11.getFloat();
        goto L97
    L88:
        this.translationZ = r11.getFloat();
        goto L97
    L89:
        this.translationY = r11.getFloat();
        goto L97
    L90:
        this.translationX = r11.getFloat();
        goto L97
    L91:
        this.rotationZ = r11.getFloat();
        goto L97
    L92:
        this.rotationY = r11.getFloat();
        goto L97
    L93:
        this.rotationX = r11.getFloat();
        goto L97
    L94:
        parseCustom(r11);
        goto L97
    L95:
        this.bottom = r11.getInt();
        goto L97
    L96:
        phone_orientation = r11.getFloat();
        goto L97
    L6:
        if (r10.equals("interpolatedPos") == false) goto L77;
        r12 = 17;
        goto L77
    L10:
        if (r10.equals("right") == false) goto L77;
        r12 = 16;
        goto L77
    L14:
        if (r10.equals("alpha") == false) goto L77;
        r12 = 15;
        goto L77
    L18:
        if (r10.equals("left") == false) goto L77;
        r12 = 14;
        goto L77
    L22:
        if (r10.equals("top") == false) goto L77;
        r12 = 13;
        goto L77
    L26:
        if (r10.equals("scaleY") == false) goto L77;
        r12 = 12;
        goto L77
    L30:
        if (r10.equals("scaleX") == false) goto L77;
        r12 = 11;
        goto L77
    L34:
        if (r10.equals("pivotY") == false) goto L77;
        r12 = 10;
        goto L77
    L38:
        if (r10.equals("pivotX") == false) goto L77;
        r12 = 9;
        goto L77
    L42:
        if (r10.equals("translationZ") == false) goto L77;
        r12 = 8;
        goto L77
    L46:
        if (r10.equals("translationY") == false) goto L77;
        r12 = 7;
        goto L77
    L50:
        if (r10.equals("translationX") == false) goto L77;
        r12 = 6;
        goto L77
    L54:
        if (r10.equals("rotationZ") == false) goto L77;
        r12 = 5;
        goto L77
    L58:
        if (r10.equals("rotationY") == false) goto L77;
        r12 = 4;
        goto L77
    L62:
        if (r10.equals("rotationX") == false) goto L77;
        r12 = 3;
        goto L77
    L66:
        if (r10.equals("custom") == false) goto L77;
        r12 = 2;
        goto L77
    L70:
        if (r10.equals("bottom") == false) goto L77;
        r12 = 1;
        goto L77
    L74:
        if (r10.equals("phone_orientation") == false) goto L77;
        r12 = 0;
        goto L77
    }

    public WidgetFrame update() {
        ConstraintWidget r10 = this.widget;
        if (r10 == null) goto L5;
        this.left = r10.getLeft();
        this.top = this.widget.getTop();
        this.right = this.widget.getRight();
        this.bottom = this.widget.getBottom();
        updateAttributes(this.widget.frame);
    L5:
        return this;
    }

    public WidgetFrame update(ConstraintWidget r10) {
        if (r10 != null) goto L4;
        return this;
    L4:
        this.widget = r10;
        update();
        return this;
    }

    public void updateAttributes(WidgetFrame r10) {
        this.pivotX = r10.pivotX;
        this.pivotY = r10.pivotY;
        this.rotationX = r10.rotationX;
        this.rotationY = r10.rotationY;
        this.rotationZ = r10.rotationZ;
        this.translationX = r10.translationX;
        this.translationY = r10.translationY;
        this.translationZ = r10.translationZ;
        this.scaleX = r10.scaleX;
        this.scaleY = r10.scaleY;
        this.alpha = r10.alpha;
        this.visibility = r10.visibility;
        this.mCustom.clear();
        Iterator<CustomVariable> r11 = r10.mCustom.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        CustomVariable r12 = r11.next();
        this.mCustom.put(r12.getName(), r12.copy());
        goto L4
    }

    public int width() {
        return Math.max(0, this.right - this.left);
    }
}
