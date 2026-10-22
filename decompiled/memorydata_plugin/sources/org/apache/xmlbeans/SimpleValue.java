package org.apache.xmlbeans;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.xml.namespace.QName;

/* JADX INFO: loaded from: classes7.dex */
public interface SimpleValue extends XmlObject {
    BigDecimal getBigDecimalValue();

    BigInteger getBigIntegerValue();

    boolean getBooleanValue();

    byte[] getByteArrayValue();

    byte getByteValue();

    Calendar getCalendarValue();

    Date getDateValue();

    double getDoubleValue();

    StringEnumAbstractBase getEnumValue();

    float getFloatValue();

    GDate getGDateValue();

    GDuration getGDurationValue();

    int getIntValue();

    List<?> getListValue();

    long getLongValue();

    Object getObjectValue();

    QName getQNameValue();

    short getShortValue();

    String getStringValue();

    SchemaType instanceType();

    void setBigDecimalValue(BigDecimal r1);

    void setBigIntegerValue(BigInteger r1);

    void setBooleanValue(boolean r1);

    void setByteArrayValue(byte[] r1);

    void setByteValue(byte r1);

    void setCalendarValue(Calendar r1);

    void setDoubleValue(double r1);

    void setEnumValue(StringEnumAbstractBase r1);

    void setFloatValue(float r1);

    void setIntValue(int r1);

    void setListValue(List<?> r1);

    void setLongValue(long r1);

    void setObjectValue(Object r1);

    void setQNameValue(QName r1);

    void setShortValue(short r1);

    void setStringValue(String r1);

    List<? extends XmlAnySimpleType> xgetListValue();
}
